package ast.switchObjects;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

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

    @Override
    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope) {
        exp = Expression.getScopeId(scope, exp);
        prev.addExpression(exp);
        return prev;
    }
}
