package ast;

import ast.interfaces.BlockStatement;
import ast.expressions.Expression;
import cfg.CFGBlock;

import java.util.HashMap;

public class Declaration implements BlockStatement {

    private Expression exp;
    private String varName;

    public Declaration(String varName, Expression exp) {
        this.exp = exp;
        this.varName = varName;
    }

    public Declaration(String varName) {
        this.exp = null;
        this.varName = varName;
    }

    public void printAST() {
        System.out.println("Declaration: " + varName);

        if(exp != null)
            exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        if(exp != null)
            block.addExpression(exp);
        return block;
    }
}
