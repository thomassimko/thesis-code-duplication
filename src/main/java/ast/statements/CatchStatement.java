package ast.statements;

import ast.Block;
import ast.expressions.left.Identifier;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatchStatement extends Statement {

    private Block body;
    private Identifier id;

    public CatchStatement(String file, int line, Identifier id, Block block) {
        super(file, line);
        this.body = block;
        this.id = id;
    }

    public void printAST() {
        System.out.println("catch: " + id);
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        pushScope(scope);
        CFGBlock blk = body.generateCFG(block, finalBlock, labelMap, start, scope);
        popScope(scope);
        return blk;
    }
}
