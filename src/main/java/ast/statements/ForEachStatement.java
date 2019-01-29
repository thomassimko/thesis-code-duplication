package ast.statements;

import ast.expressions.Expression;
import ast.expressions.Identifier;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;

import java.util.HashMap;

public class ForEachStatement extends Statement {

    private Expression exp;
    private Statement body;
    private Identifier declaredId = null;

    public ForEachStatement(int line, Expression exp, Statement body, String declaredId) {
        super(line);
        this.exp = exp;
        this.declaredId = new Identifier(line, declaredId);
        this.body = body;
    }

    public void printAST() {
        System.out.println("For each: " + declaredId);
        exp.printAST();
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {

        CFGBlock forBlock = new LoopBlock();
        CFGBlock newBlock = new BasicBlock();

        forBlock.addExpression(declaredId);
        forBlock.addExpression(exp);

        CFGBlock endBlock = body.generateCFG(forBlock, finalBlock, labelMap);

        block.addSuccessor(forBlock);
        forBlock.addSuccessor(newBlock);
        endBlock.addSuccessor(newBlock);

        return newBlock;
    }
}
