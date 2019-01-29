package cfg;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class CFGBlock {

    List<Expression> expressionList;
    List<CFGBlock> successors;
    String label;

    public CFGBlock(String label) {
        this.label = label + BlockCounter.getNextBlockLabel();
        this.expressionList = new ArrayList<Expression>();
        this.successors = new ArrayList<CFGBlock>();
    }

    public void addExpression(Expression exp) {
        expressionList.add(exp);
    }

    public void addSuccessor(CFGBlock successor) {
        successors.add(successor);
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
            for (CFGBlock successor : successors) {
                output.append(this.label + " -> " + successor.getLabel() + "\n");
                successor.getGraphVisFormat(visited, output);
            }
        }
    }

}
