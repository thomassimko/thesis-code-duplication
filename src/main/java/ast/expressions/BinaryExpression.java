package ast.expressions;

import java.util.ArrayList;
import java.util.List;

public class BinaryExpression extends Expression {

    private String operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(int line, String operator, Expression left, Expression right) {
        super(line);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public void printAST() {
        System.out.println("Binary Exp: " + operator);
        left.printAST();
        right.printAST();
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator + " " + right.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(left.getExpressions());
        output.addAll(right.getExpressions());
        output.add(this);
        return output;
    }
}
