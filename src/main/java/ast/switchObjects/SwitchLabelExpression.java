package ast.switchObjects;

import ast.expressions.Expression;

public class SwitchLabelExpression extends SwitchLabel {

    private Expression exp;

    public SwitchLabelExpression(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Option Expression: ");
        exp.printAST();
    }
}
