package ast.statements;

import ast.Block;
import ast.expressions.AssignmentExpression;
import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TryStatement extends Statement {

    private Block tryBlock;
    private List<CatchStatement> catches;
    private Block finallyBlock;
    private List<AssignmentExpression> resources;

    public TryStatement(String file, int line, Block tryBlock, List<CatchStatement> catches, Block finallyBlock, List<AssignmentExpression> resources) {
        super(file, line);
        this.tryBlock = tryBlock;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
        this.resources = resources;
    }

    public void printAST() {
        System.out.println("Try");
        for(AssignmentExpression resource:resources) {
            resource.printAST();
        }
        for(CatchStatement stmt: catches) {
            stmt.printAST();
        }
        finallyBlock.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        CFGBlock finallyCFG = null;
        CFGBlock tryCFG = new BasicBlock();
        CFGBlock endBlock = new BasicBlock();

        start.addBlock(tryCFG);
        start.addBlock(endBlock);

        for(AssignmentExpression assgn: resources) {
            Expression newExp = Expression.getScopeId(scope, assgn);
            tryCFG.addExpression(newExp);
        }

        CFGBlock lastTryCFG = tryBlock.generateCFG(tryCFG, finalBlock, labelMap, start, scope);

        if(finallyBlock != null) {

            pushScope(scope);
            finallyCFG = new BasicBlock();
            start.addBlock(finallyCFG);
            CFGBlock lastFinallyCFG = finallyBlock.generateCFG(finallyCFG, finalBlock, labelMap, start, scope);

            lastTryCFG.addSuccessor(finallyCFG);
            lastFinallyCFG.addSuccessor(endBlock);
            popScope(scope);
        }

        for(CatchStatement catchStmt : catches) {
            pushScope(scope);
            CFGBlock catchBlock = new BasicBlock();
            start.addBlock(catchBlock);
            CFGBlock lastCatchBlock = catchStmt.generateCFG(catchBlock, finalBlock, labelMap, start, scope);

            lastTryCFG.addSuccessor(catchBlock);

            if(finallyCFG != null) {
                lastCatchBlock.addSuccessor(finallyCFG);
            } else {
                lastCatchBlock.addSuccessor(endBlock);
            }
            popScope(scope);
        }

        return endBlock;
    }
}
