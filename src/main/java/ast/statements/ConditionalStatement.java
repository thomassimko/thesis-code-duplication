package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConditionalStatement extends Statement{

    private Expression condition;
    private Statement ifTrue;
    private Statement ifFalse;

    public ConditionalStatement(String file, int line, Expression condition, Statement ifTrue, Statement ifFalse) {
        super(file, line);
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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        condition = Expression.getScopeId(scope, condition);
        block.addExpression(condition);


        CFGBlock trueBlock = new BasicBlock("true");
        CFGBlock newBlock = new BasicBlock("join");

        start.addBlock(trueBlock);

        block.addSuccessor(trueBlock);
        pushScope(scope);
        CFGBlock lastTrue = ifTrue.generateCFG(trueBlock, finalBlock, labelMap, start, scope);
        popScope(scope);
        lastTrue.addSuccessor(newBlock);

        if(ifFalse != null) {
            CFGBlock falseBlock = new BasicBlock("false");
            block.addSuccessor(falseBlock);
            start.addBlock(falseBlock);
            pushScope(scope);
            CFGBlock lastFalse = ifFalse.generateCFG(falseBlock, finalBlock, labelMap, start, scope);
            popScope(scope);
            lastFalse.addSuccessor(newBlock);
        } else {
            block.addSuccessor(newBlock);
        }

        start.addBlock(newBlock);


        return newBlock;
    }
}
