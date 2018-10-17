package ast.expressions;

import ast.interfaces.Expression;

public class TernaryExpression implements Expression{

    private Expression trueExp;
    private Expression falseExp;
    private Expression cond;

    public TernaryExpression(Expression cond, Expression trueExp, Expression falseExp) {
        this.cond = cond;
        this.trueExp = trueExp;
        this.falseExp = falseExp;
    }
}
