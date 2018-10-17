package ast.expressions;

import ast.interfaces.Expression;

public class BinaryExpression implements Expression{

    private String operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(String operator, Expression left, Expression right) {

    }
}
