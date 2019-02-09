package ast.statements;

import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class BreakStatement extends Statement {

    private String id;

    public BreakStatement(int line) {
        super(line);

    }

    public BreakStatement(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("break: " + id);
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        if(id != null) {
            block.addSuccessor(labelMap.get(id));
        }
        return block;
    }
}
