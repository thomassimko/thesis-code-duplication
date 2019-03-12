package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnStatement extends Statement {

    private Expression exp;

    public ReturnStatement(String file, int line, Expression exp) {
        super(file, line);
        this.exp = exp;
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        if(exp != null) {
            exp = Expression.getScopeId(scope, exp);
            block.addExpression(exp);
        }
        block.addSuccessor(finalBlock);
        return finalBlock;
    }
}
