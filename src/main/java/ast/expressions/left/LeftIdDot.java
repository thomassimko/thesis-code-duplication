package ast.expressions.left;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class LeftIdDot extends Left {
    private String id;
    private Expression left;

    public LeftIdDot(int line, String id, Expression left) {
        super(line);
        this.id = id;
        this.left = left;
    }

    @Override
    public void printAST() {
        System.out.println("left id: " + id);
        left.printAST();
    }

    @Override
    public String toString() {
        return left.toString() + "." + id;
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(left.getExpressions());
        output.add(this);
        return output;
    }

    //PER METHOD
    //if i hit a left, add it (still check the rest)
    //if assignment , post/pre then add left to target
    //
}
