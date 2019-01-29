package ast.statements;

import cfg.BasicBlock;
import cfg.CFGBlock;

import java.util.HashMap;

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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {

        CFGBlock newBlock = new BasicBlock(label);
        block.addSuccessor(newBlock);

        labelMap.put(label, newBlock);

        return stmt.generateCFG(newBlock, finalBlock, labelMap);
    }
}
