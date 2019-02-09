package ast.statements;

import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class ConditionalStatement extends Statement{

    private Expression condition;
    private Statement ifTrue;
    private Statement ifFalse;

    public ConditionalStatement(int line, Expression condition, Statement ifTrue, Statement ifFalse) {
        super(line);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public void printAST() {
        System.out.println("conditional: ");
        condition.printAST();
        ifTrue.printAST();

        if(ifFalse != null)
            ifFalse.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {
        block.addExpressions(condition.getExpressions());

        CFGBlock trueBlock = new BasicBlock("true");
        CFGBlock newBlock = new BasicBlock("join");

        start.addBlock(trueBlock);
        start.addBlock(newBlock);

        block.addSuccessor(trueBlock);
        CFGBlock lastTrue = ifTrue.generateCFG(trueBlock, finalBlock, labelMap, start);
        lastTrue.addSuccessor(newBlock);

        if(ifFalse != null) {
            CFGBlock falseBlock = new BasicBlock("false");
            block.addSuccessor(falseBlock);
            start.addBlock(falseBlock);
            CFGBlock lastFalse = ifFalse.generateCFG(falseBlock, finalBlock, labelMap, start);
            lastFalse.addSuccessor(newBlock);
        } else {
            block.addSuccessor(newBlock);
        }


        return newBlock;
    }
}
