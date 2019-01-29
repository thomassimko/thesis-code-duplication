package ast.statements;

import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;

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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        block.addExpression(condition);

        CFGBlock trueBlock = new BasicBlock("true");
        CFGBlock newBlock = new BasicBlock("join");

        block.addSuccessor(trueBlock);
        CFGBlock lastTrue = ifTrue.generateCFG(trueBlock, finalBlock, labelMap);
        lastTrue.addSuccessor(newBlock);

        if(ifFalse != null) {
            CFGBlock falseBlock = new BasicBlock("false");
            block.addSuccessor(falseBlock);
            CFGBlock lastFalse = ifFalse.generateCFG(falseBlock, finalBlock, labelMap);
            lastFalse.addSuccessor(newBlock);
        } else {
            block.addSuccessor(newBlock);
        }


        return newBlock;
    }
}
