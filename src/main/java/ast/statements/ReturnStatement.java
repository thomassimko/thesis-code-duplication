package ast.statements;

import ast.expressions.Expression;
import cfg.CFGBlock;

import java.util.HashMap;

public class ReturnStatement extends Statement {

    private Expression exp;

    public ReturnStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Return");
        exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        block.addExpression(exp);
        block.addSuccessor(finalBlock);
        return finalBlock;
    }
}
