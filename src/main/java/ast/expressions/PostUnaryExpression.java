package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;

public class PostUnaryExpression extends Expression {

    private String op;
    private Expression exp;

    public PostUnaryExpression(int line, String op, Expression exp) {
        super(line);
        this.op = op;
        this.exp = exp;

        addTarget(exp);
    }

    @Override
    public void printAST() {
        System.out.println("Unary: " + op);
        exp.printAST();
    }

    @Override
    public String toString() {
        return "(" + exp.toString() + "++" + ")";
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(exp.getExpressions());
        output.add(this);
        return output;
    }
}
