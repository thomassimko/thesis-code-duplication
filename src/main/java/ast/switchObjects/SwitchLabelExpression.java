package ast.switchObjects;

import ast.interfaces.Expression;

public class SwitchLabelExpression implements SwitchLabel {

    private Expression exp;

    public SwitchLabelExpression(Expression exp) {
        this.exp = exp;
    }
}
