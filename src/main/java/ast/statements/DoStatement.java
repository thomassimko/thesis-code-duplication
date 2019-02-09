package ast.statements;

import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class DoStatement extends Statement {
    private Statement stmt;
    private Expression exp;

    public DoStatement(int line, Statement stmt, Expression exp) {
        super(line);
        this.stmt = stmt;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("do");
        exp.printAST();
        stmt.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        CFGBlock newBlock = new BasicBlock();
        CFGBlock whileBlock = new LoopBlock();
        CFGBlock lastBlock = stmt.generateCFG(whileBlock, finalBlock, labelMap, start);
        block.addSuccessor(whileBlock);
        lastBlock.addSuccessor(newBlock);

        lastBlock.addExpressions(exp.getExpressions());

        start.addBlock(newBlock);
        start.addBlock(whileBlock);

        return newBlock;
    }
}
