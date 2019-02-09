package ast.statements;

import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class ContinueStatement extends Statement {

    private String id;

    public ContinueStatement(int line) {
        super(line);
    }

    public ContinueStatement(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("Continue: " + id);
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        if(id == null) {
            block.addSuccessor(labelMap.get(id));
        }
        return block;
    }
}
