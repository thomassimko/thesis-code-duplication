package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WhileStatement extends Statement {

    private Expression exp;
    private Statement stmt;

    public WhileStatement(String file, int line, Expression exp, Statement stmt) {
        super(file, line);
        this.stmt = stmt;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("while: ");
        exp.printAST();
        stmt.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);

        exp = Expression.getScopeId(scope, exp);
        block.addExpression(exp);

        CFGBlock loopBlock = new LoopBlock();
        CFGBlock endBlock = new BasicBlock();
        block.addSuccessor(loopBlock);
        block.addSuccessor(endBlock);
        start.addBlock(loopBlock);
        start.addBlock(endBlock);

        CFGBlock newBlock = stmt.generateCFG(loopBlock, finalBlock, labelMap, start, scope);
        newBlock.addExpression(exp);
        newBlock.addSuccessor(loopBlock);
        newBlock.addSuccessor(endBlock);
        
        popScope(scope);

        return endBlock;
    }
}
