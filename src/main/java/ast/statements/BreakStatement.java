package ast.statements;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        if(id != null) {
            block.addSuccessor(labelMap.get(id));
        }
        return block;
    }
}
