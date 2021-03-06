package ast.switchObjects;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

public class SwitchLabelExpression extends SwitchLabel {

    private Expression exp;

    public SwitchLabelExpression(String file, int line, Expression exp) {
        super(file, line);
        this.exp = exp;
    }

    @Override
    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope) {
        exp = Expression.getScopeId(scope, exp);
        prev.addExpression(exp);
        return prev;
    }
}
