package cfg;

import ast.expressions.*;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class CFGBlock {

    List<Expression> expressionList;
    List<CFGBlock> successors;
    List<CFGBlock> predecessors;
    List<Expression> genSet;
    String label;
    List<Left> targets;

    public CFGBlock(String label) {
        this.label = label + BlockCounter.getNextBlockLabel();
        this.expressionList = new ArrayList<Expression>();
        this.successors = new ArrayList<CFGBlock>();
        this.predecessors = new ArrayList<CFGBlock>();
        this.genSet = new ArrayList<Expression>();
        this.targets = new ArrayList<Left>();
    }

    public void addExpressions(List<Expression> exp) {
        expressionList.addAll(exp);
    }

    public void addExpression(Expression exp) {
        expressionList.add(exp);
    }

    public void addSuccessor(CFGBlock successor) {
        successors.add(successor);
        successor.addPredecessor(this);
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

    public void setTargets() {
        targets = new ArrayList<Left>();
        for(Expression exp: expressionList) {
            targets.addAll(exp.getTargets());
        }
    }

    public void printTargets() {
        for(Left left: targets) {
            System.out.println(left.toString());
        }
    }

    public void setKillSet() {
        //Assignments
    }

}
