package ast.statements;

import ast.Block;
import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class SynchronizedStatement extends Statement {

    private Block body;
    private Expression exp;

    public SynchronizedStatement(int line, Block block, Expression exp) {
        super(line);
        this.body = block;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Synchronized: ");
        exp.printAST();
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {
        block.addExpression(exp);

        CFGBlock syncBlock = new BasicBlock();
        block.addSuccessor(syncBlock);

        CFGBlock newBlock = body.generateCFG(syncBlock, finalBlock, labelMap, start);

        return newBlock;
    }
}
