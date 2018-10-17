package ast.expressions;

import ast.interfaces.Expression;

public class UnaryExpression implements Expression {

    private String op;
    private Expression exp;

    public UnaryExpression(String op, Expression exp) {
        this.op = op;
        this.exp = exp;
    }
}
