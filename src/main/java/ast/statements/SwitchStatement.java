package ast.statements;

import ast.expressions.Expression;
import ast.switchObjects.SwitchOption;

import java.util.List;

public class SwitchStatement extends Statement {

    private List<SwitchOption> options;
    private Expression exp;

    public SwitchStatement(int line, Expression exp, List<SwitchOption> options) {
        super(line);
        this.options = options;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Switch:");
        exp.printAST();
        for(SwitchOption option : options) {
            option.printAST();
        }
    }
}
