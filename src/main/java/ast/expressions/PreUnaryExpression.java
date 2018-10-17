package ast.expressions;

import ast.interfaces.Expression;

public class PreUnaryExpression implements Expression {

    private String op;
    private Expression exp;

    public PreUnaryExpression(String op, Expression exp) {
            this.op = op;
            this.exp = exp;

        }
}
