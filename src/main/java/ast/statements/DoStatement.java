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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);

        CFGBlock newBlock = new BasicBlock();
        CFGBlock whileBlock = new LoopBlock();
        CFGBlock conditionBlock = new BasicBlock();

        pushScope(scope);
        CFGBlock lastBlock = stmt.generateCFG(whileBlock, finalBlock, labelMap, start, scope);
        popScope(scope);

        lastBlock.addSuccessor(conditionBlock);

        exp = Expression.getScopeId(scope, exp);
        conditionBlock.addExpressions(exp.getExpressions());
        conditionBlock.addSuccessor(whileBlock);
        conditionBlock.addSuccessor(newBlock);

        block.addSuccessor(whileBlock);

        start.addBlock(whileBlock);
        start.addBlock(conditionBlock);
        start.addBlock(newBlock);

        return newBlock;
    }
}
