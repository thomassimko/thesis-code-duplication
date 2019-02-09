package ast.statements;

import ast.expressions.Expression;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class ThrowStatement extends Statement {

    private Expression exp;

    public ThrowStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Throw:");
        exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {
        block.addExpression(exp);
        return block;
    }
}
