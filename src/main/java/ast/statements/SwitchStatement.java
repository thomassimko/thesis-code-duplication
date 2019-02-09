package ast.statements;

import ast.expressions.Expression;
import ast.switchObjects.SwitchOption;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;
import cfg.SwitchOptionBlock;

import java.util.HashMap;
import java.util.List;

public class SwitchStatement extends Statement {

    private List<SwitchOption> options;
    private Expression exp;

    public SwitchStatement(int line, Expression exp, List<SwitchOption> options) {
        super(line);
        this.options = options;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Switch:");
        exp.printAST();
        for(SwitchOption option : options) {
            option.printAST();
        }
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        CFGBlock endBlock = new BasicBlock();

        block.addExpression(exp);

        for(SwitchOption option: options) {
            SwitchOptionBlock optionBlock = new SwitchOptionBlock(option);
            CFGBlock newBlock = option.generateCFG(optionBlock, finalBlock, start);

            block.addSuccessor(optionBlock);
            newBlock.addSuccessor(endBlock);
        }


        return endBlock;
    }
}
