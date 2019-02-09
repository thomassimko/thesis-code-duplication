package ast.statements;

import ast.expressions.Expression;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class AssertStatement extends Statement {

    private Expression exp;
    private Expression detail;

    public AssertStatement(int line, Expression exp, Expression detail) {
        super(line);
        this.exp = exp;
        this.detail = detail;
    }

    public void printAST() {
        System.out.println("Assert:");
        exp.printAST();
        detail.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {
        block.addExpressions(exp.getExpressions());
        block.addExpressions(detail.getExpressions());

        return block;
    }
}
