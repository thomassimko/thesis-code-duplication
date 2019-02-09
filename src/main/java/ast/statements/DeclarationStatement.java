package ast.statements;

import ast.expressions.AssignmentExpression;
import ast.expressions.left.Identifier;
import ast.interfaces.BlockStatement;
import ast.expressions.Expression;
import ast.statements.Statement;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public class DeclarationStatement extends Statement {

    private Expression exp;
    private String varName;

    public DeclarationStatement(int line, String varName, Expression exp) {
        super(line);
        this.varName = varName;

        if(exp != null) {
            Identifier id = new Identifier(line, varName);
            this.exp = new AssignmentExpression(line, id, "=", exp);
        }
    }

    public void printAST() {
        System.out.println("DeclarationStatement: " + varName);

        if(exp != null)
            exp.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {
        if(exp != null) {
            block.addExpressions(exp.getExpressions());
        }
        return block;
    }

    public Expression getExpression() {
        return exp;
    }
}
