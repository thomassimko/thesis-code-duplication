package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpressionStatement extends Statement {

    private Expression exp;

    public ExpressionStatement(String file, int line, Expression exp) {
        super(file, line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Expression Statement");
        if(exp != null)
            exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        exp = Expression.getScopeId(scope, exp);
        block.addExpression(exp);
        return block;
    }
}
