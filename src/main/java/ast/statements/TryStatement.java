package ast.statements;

import ast.Block;
import ast.expressions.AssignmentExpression;
import cfg.BasicBlock;
import cfg.CFGBlock;

import java.util.HashMap;
import java.util.List;

public class TryStatement extends Statement {

    private Block tryBlock;
    private List<CatchStatement> catches;
    private Block finallyBlock;
    private List<AssignmentExpression> resources;

    public TryStatement(int line, Block tryBlock, List<CatchStatement> catches, Block finallyBlock, List<AssignmentExpression> resources) {
        super(line);
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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {

        CFGBlock finallyCFG = null;
        CFGBlock tryCFG = new BasicBlock();
        CFGBlock endBlock = new BasicBlock();

        for(AssignmentExpression assgn: resources) {
            tryCFG.addExpression(assgn);
        }

        CFGBlock lastTryCFG = tryBlock.generateCFG(tryCFG, finalBlock, labelMap);

        if(finallyBlock != null) {
            finallyCFG = new BasicBlock();
            CFGBlock lastFinallyCFG = finallyBlock.generateCFG(finallyCFG, finalBlock, labelMap);

            lastTryCFG.addSuccessor(finallyCFG);
            lastFinallyCFG.addSuccessor(endBlock);
        }

        for(CatchStatement catchStmt : catches) {
            CFGBlock catchBlock = new BasicBlock();
            CFGBlock lastCatchBlock = catchStmt.generateCFG(catchBlock, finalBlock, labelMap);

            lastTryCFG.addSuccessor(catchBlock);

            if(finallyCFG != null) {
                lastCatchBlock.addSuccessor(finallyCFG);
            } else {
                lastCatchBlock.addSuccessor(endBlock);
            }
        }

        return endBlock;
    }
}
