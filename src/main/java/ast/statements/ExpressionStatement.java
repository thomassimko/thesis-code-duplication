package ast.statements;

import ast.expressions.Expression;
import cfg.CFGBlock;

import java.util.HashMap;

public class ExpressionStatement extends Statement {

    private Expression exp;

    public ExpressionStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Expression Statement");
        if(exp != null)
            exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        block.addExpression(exp);
        return block;
    }
}