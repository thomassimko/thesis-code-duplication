package ast.statements;

import ast.expressions.AssignmentExpression;
import ast.expressions.Expression;
import ast.expressions.left.Identifier;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachStatement extends Statement {

    private Statement body;
    private Expression assgn;

    public ForEachStatement(int line, Expression exp, Statement body, String id) {
        super(line);
        Identifier declaredId = new Identifier(line, id);
        this.body = body;
        assgn = new AssignmentExpression(line, declaredId, "=", exp);
    }

    public void printAST() {
        System.out.println("For each: ");
        assgn.printAST();
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);

        CFGBlock forBlock = new LoopBlock();
        CFGBlock newBlock = new BasicBlock();

        start.addBlock(forBlock);
        start.addBlock(newBlock);

        assgn = Expression.getScopeId(scope, assgn);
        forBlock.addExpressions(assgn.getExpressions());

        CFGBlock endBlock = body.generateCFG(forBlock, finalBlock, labelMap, start, scope);

        block.addSuccessor(forBlock);
        forBlock.addSuccessor(newBlock);
        endBlock.addSuccessor(forBlock);

        if(forBlock != endBlock)
            endBlock.addSuccessor(newBlock);

        popScope(scope);

        return newBlock;
    }
}
