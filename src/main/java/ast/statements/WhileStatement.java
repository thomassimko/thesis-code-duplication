package ast.statements;

import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class WhileStatement extends Statement {

    private Expression exp;
    private Statement stmt;

    public WhileStatement(int line, Expression exp, Statement stmt) {
        super(line);
        this.stmt = stmt;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("while: ");
        exp.printAST();
        stmt.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        block.addExpression(exp);
        CFGBlock loopBlock = new LoopBlock();
        CFGBlock endBlock = new BasicBlock();
        block.addSuccessor(loopBlock);
        block.addSuccessor(endBlock);
        start.addBlock(loopBlock);
        start.addBlock(endBlock);

        CFGBlock newBlock = stmt.generateCFG(loopBlock, finalBlock, labelMap, start);
        newBlock.addExpression(exp);
        newBlock.addSuccessor(loopBlock);
        newBlock.addSuccessor(endBlock);

        return endBlock;
    }
}
