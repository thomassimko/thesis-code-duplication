package cfg;

import ast.expressions.*;
import ast.expressions.left.Left;
import java.util.*;
import java.util.function.BiConsumer;

public abstract class CFGBlock {

    private List<Expression> expressionList;

    private List<CFGBlock> successors;
    private List<CFGBlock> predecessors;
    private String label;
    private List<Left> targets;
    private List<Left> sources;
    private HashMap<Left, Expression> gen;
    private HashMap<Left, Expression> kill;
    private HashMap<Left, Set<Expression>> liveOut;

    private static LiveOutComparator liveOutComparator = new LiveOutComparator();

    public CFGBlock(String label) {
        this.label = label + BlockCounter.getNextBlockLabel();
        this.expressionList = new ArrayList<>();
        this.successors = new ArrayList<>();
        this.predecessors = new ArrayList<>();
        this.targets = new ArrayList<>();
        this.sources = new ArrayList<>();
        this.gen = new HashMap<>();
        this.kill = new HashMap<>();
        this.liveOut = new HashMap<>();
    }

    public void addExpression(Expression exp) {
        Expression newExp = exp.transformToTemp(expressionList);
        if (!(newExp instanceof Left))
            expressionList.add(newExp);
    }

    public void addSuccessor(CFGBlock successor) {
        if(successor != null) {
            successors.add(successor);
            successor.addPredecessor(this);
        }
    }

    public List<Expression> getExpressions() {
        return expressionList;
    }

    public void addPredecessor(CFGBlock pred) {
        predecessors.add(pred);
    }

    public String getLabel() {
        return label;
    }

    public void getGraphVisFormat(Set<CFGBlock> visited, StringBuilder output) {

        if(!visited.contains(this)) {
            visited.add(this);
            for(CFGBlock pred : predecessors) {
                output.append(this.label + " -> " + pred.getLabel() + " [style=dashed]\n");
            }
            for (CFGBlock successor : successors) {
                output.append(this.label + " -> " + successor.getLabel() + "\n");
                successor.getGraphVisFormat(visited, output);
            }
        }
    }

    public void setTargetsAndSources() {
        targets = new ArrayList<>();
        sources = new ArrayList<>();
        for(Expression exp: expressionList) {
            exp.setUsesAndDefines();
            targets.addAll(exp.getTargets());
            sources.addAll(exp.getSources());
        }
    }

    public void printTargets() {
        System.out.println("Targets: ");
        for(Left left: targets) {
            System.out.println(left.toString());
        }
    }

    public void printSources() {
        System.out.println("Sources: ");
        for(Left left: sources) {
            System.out.println(left.toString());
        }

    }

    public void setGenKillSet() {

        this.gen = new HashMap<>();
        this.kill = new HashMap<>();

        for(int i = expressionList.size() - 1; i >= 0; i--) {

            Expression exp = expressionList.get(i);
            List<Left> targets = exp.getTargets();



            for(int j = targets.size() - 1; j >= 0; j--) {
                Left target = targets.get(j);
                if(!gen.containsKey(target)) {
                    gen.put(target, exp);
                } else {
                    kill.put(target, exp);
                }
            }
        }
//
//        System.err.println(this.getLabel());
//        System.err.println("Gen: ");
//        for(Left left: gen.keySet()) {
//            System.err.println("\t" + left.toString());
//        }
//        System.err.println("Kill: ");
//        for(Left left: kill.keySet()) {
//            System.err.println("\t" + left.toString());
//        }
//        System.err.println();
    }

    public void setLiveOut(Queue<CFGBlock> changed) {

        //out = gen
        HashMap<Left, Set<Expression>> newLiveOut = new HashMap<>();
        for(Left key: gen.keySet()) {
            Set<Expression> newExp = new HashSet<>();
            newExp.add(gen.get(key));
            newLiveOut.put(key, newExp);
        }

        //in = in U (pred - kill)
        HashMap<Left, Set<Expression>> in = new HashMap<>();
        for(CFGBlock predBlock : predecessors) {
            Map<Left, Set<Expression>> pred = predBlock.getLiveOut();
            for(Left key : pred.keySet()) {
                //pred - kill
                if(!kill.containsKey(key)) {
                    if (in.containsKey(key)) {
                        in.get(key).addAll(pred.get(key));
                    } else {
                        Set<Expression> newSet = new HashSet<>(pred.get(key));
                        in.put(key, newSet);
                    }
                }
            }
        }

        //LO = gen + in
        //ignore values already in gen because only new values matter
        for(Left key: in.keySet()) {
            if(!newLiveOut.containsKey(key)) {
                newLiveOut.put(key, in.get(key));
            }
        }

        if(liveOutComparator.compare(this.liveOut, newLiveOut) != 0) {
            this.liveOut = newLiveOut;
            changed.addAll(successors);
        }
    }

    public void setDependents() {
        HashMap<Left, Expression> gen = new HashMap<>();

        BiConsumer<Left, Expression> addFromGenWaw = (a,cur) -> gen.get(a).addWawDependent(cur);
        BiConsumer<Expression, Expression> addFromPredWaw = (a,cur) -> a.addWawDependent(cur);

        BiConsumer<Left, Expression> addFromGen = (a,cur) -> gen.get(a).addDataDependents(cur);
        BiConsumer<Expression, Expression> addFromPred = (a,cur) -> a.addDataDependents(cur);


        for(int i = 0; i < expressionList.size(); i++) {
            Expression cur = expressionList.get(i);

            setDependentsHelper(cur, cur.getSources(), gen, addFromGen, addFromPred);
            setDependentsHelper(cur, cur.getTargets(), gen, addFromGenWaw, addFromPredWaw);

            for(Left target : cur.getTargets()) {
                gen.put(target, cur);
            }

        }
    }

    private void setDependentsHelper(Expression cur, List<Left> useTar, HashMap<Left, Expression> gen, BiConsumer<Left, Expression> addFromGen, BiConsumer<Expression, Expression> addFromPred) {
        for(Left lft : useTar) {
            if(gen.containsKey(lft)) {
                addFromGen.accept(lft, cur);
            } else {
                for (CFGBlock pred : predecessors) {
                    Set<Expression> defs = pred.getLiveOut().get(lft);
                    if (defs != null) {
                        for (Expression def : defs) {
                            addFromPred.accept(def,cur);
                        }
                    }
                }
            }
        }
    }

    public HashMap<Left, Set<Expression>> getLiveOut() {
        return liveOut;
    }

}
