package ast.statements;

import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabeledStatement extends Statement {

    private String label;
    private Statement stmt;

    public LabeledStatement(int line, String label, Statement stmt) {
        super(line);
        this.label = label;
        this.stmt = stmt;
    }

    public void printAST() {
        System.out.println("Label: " + label);
        stmt.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        CFGBlock newBlock = new BasicBlock(label);
        block.addSuccessor(newBlock);

        labelMap.put(label, newBlock);

        return stmt.generateCFG(newBlock, finalBlock, labelMap, start, scope);
    }
}
