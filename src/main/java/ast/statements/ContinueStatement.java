package ast.statements;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        if(id == null) {
            block.addSuccessor(labelMap.get(id));
        }
        return block;
    }
}
