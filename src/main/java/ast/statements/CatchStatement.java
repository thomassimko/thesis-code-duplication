package ast.statements;

import ast.Block;
import ast.expressions.Identifier;
import cfg.CFGBlock;

import java.util.HashMap;

public class CatchStatement extends Statement {

    private Block body;
    private Identifier id;

    public CatchStatement(int line, Identifier id, Block block) {
        super(line);
        this.body = block;
        this.id = id;
    }

    public void printAST() {
        System.out.println("catch: " + id);
        body.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        return body.generateCFG(block, finalBlock, labelMap);
    }
}
