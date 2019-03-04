package cfg;

import ast.expressions.*;
import ast.expressions.left.Identifier;
import ast.expressions.left.Left;

import java.util.*;

public abstract class CFGBlock {

    private List<Expression> expressionList;

    private List<CFGBlock> successors;
    private List<CFGBlock> predecessors;
    private String label;
    private List<Left> targets;
    private List<Left> sources;
    private Set<Left> gen;
    private Set<Left> kill;
    private Set<Left> liveOut;

    public CFGBlock(String label) {
        this.label = label + BlockCounter.getNextBlockLabel();
        this.expressionList = new ArrayList<Expression>();
        this.successors = new ArrayList<CFGBlock>();
        this.predecessors = new ArrayList<CFGBlock>();
        this.targets = new ArrayList<Left>();
        this.sources = new ArrayList<Left>();
        this.gen = new HashSet<Left>();
        this.kill = new HashSet<Left>();
        this.liveOut = new HashSet<Left>();
    }

    public void addExpression(Expression exp) {
        Expression newExp = exp.transformToTemp(expressionList);
        if(!(newExp instanceof Left))
            expressionList.add(newExp);
    }

    public void addSuccessor(CFGBlock successor) {
        successors.add(successor);
        successor.addPredecessor(this);
    }

    public List<Expression> getExpressions() {
        return expressionList;
    }

    public void addPredecessor(CFGBlock pred) {
        predecessors.add(pred);
    }

    public void printBlock(Set<CFGBlock> visited) {
        if(visited.contains(this)) {
            System.out.print("already visited: " + label);
            return;
        }

        visited.add(this);
        System.out.println(label);
        for(Expression exp: expressionList) {
            System.out.print("\t");
            exp.printAST();
        }
        for(CFGBlock block:successors) {
            block.printBlock(visited);
        }
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
        targets = new ArrayList<Left>();
        sources = new ArrayList<Left>();
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

        this.gen = new HashSet<Left>();
        this.kill = new HashSet<Left>();

        for(int i = expressionList.size() - 1; i >= 0; i--) {

            Expression exp = expressionList.get(i);
            List<Left> targets = exp.getTargets();

            for(int j = targets.size() - 1; j >= 0; j--) {
                Left target = targets.get(j);
                if(!kill.contains(target)) {
                    gen.add(target);
                } else {
                    kill.add(target);
                }
            }

        }
    }

    public void setLiveOut(Queue<CFGBlock> changed) {

        Set<Left> newLiveOut = new HashSet<>(gen);
        Set<Left> in = new HashSet<>();
        for(CFGBlock pred : predecessors) {
            in.addAll(pred.getLiveOut());
        }
        in.removeAll(kill);
        newLiveOut.addAll(in);

        boolean equals = newLiveOut.size() == liveOut.size();

        if(equals) {
            String[] liveOutArr = liveOut.stream().map(Left::toString).toArray(String[]::new);
            String[] newLiveOutArr = newLiveOut.stream().map(Left::toString).toArray(String[]::new);
            Arrays.sort(liveOutArr);
            Arrays.sort(newLiveOutArr);

            for(int i = 0; i < liveOutArr.length; i++) {
                if (!liveOutArr[i].equals(newLiveOutArr[i])) {
                    equals = false;
                }
            }
        }

        if(!equals) {
            this.liveOut = newLiveOut;
            changed.addAll(successors);
        }
    }

    public Set<Left> getLiveOut() {
        return liveOut;
    }

}
