package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssertStatement extends Statement {

    private Expression exp;
    private Expression detail;

    public AssertStatement(String file, int line, Expression exp, Expression detail) {
        super(file, line);
        this.exp = exp;
        this.detail = detail;
    }

    public void printAST() {
        System.out.println("Assert:");
        exp.printAST();
        detail.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        this.setExpressionScope(scope);


        block.addExpression(exp);
        block.addExpression(detail);

        return block;
    }

    private void setExpressionScope(List<Map<String, Left>> scope) {
        exp = Expression.getScopeId(scope, exp);
        detail = Expression.getScopeId(scope, detail);
    }
}
