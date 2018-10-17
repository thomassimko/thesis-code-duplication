package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;
import ast.switchObjects.SwitchOption;

import java.util.List;

public class SwitchStatement implements Statement {

    private List<SwitchOption> options;
    private Expression exp;

    public SwitchStatement(Expression exp, List<SwitchOption> options) {
        this.options = options;
        this.exp = exp;
    }



}
