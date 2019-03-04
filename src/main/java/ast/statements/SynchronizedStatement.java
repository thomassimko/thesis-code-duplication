package ast.statements;

import ast.Block;
import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedStatement extends Statement {

    private Block body;
    private Expression exp;

    public SynchronizedStatement(String file, int line, Block block, Expression exp) {
        super(file, line);
        this.body = block;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Synchronized: ");
        exp.printAST();
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);

        exp = Expression.getScopeId(scope, exp);
        block.addExpression(exp);

        CFGBlock syncBlock = new BasicBlock();
        block.addSuccessor(syncBlock);

        CFGBlock newBlock = body.generateCFG(syncBlock, finalBlock, labelMap, start, scope);

        popScope(scope);

        return newBlock;
    }
}
