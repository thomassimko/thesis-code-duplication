package ast.statements;

import ast.expressions.AssignmentExpression;
import ast.expressions.left.Identifier;
import ast.expressions.left.Left;
import ast.expressions.Expression;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeclarationStatement extends Statement {

    private AssignmentExpression exp;
    private Identifier varName;

    public DeclarationStatement(int line, Identifier varName, Expression exp) {
        super(line);
        this.varName = varName;
        this.exp = (AssignmentExpression) exp;
    }

    public void printAST() {
        System.out.println("DeclarationStatement: " + varName);

        if(exp != null)
            exp.printAST();
    }

    @Override
    public String toString() {
        if(exp != null)
            return "declared: " + varName.toString() + " : " + exp.toString();
        return "declared: " + varName.toString();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {
        //exp = Expression.getScopeId(scope, exp);
        if(exp != null) {
            exp.replaceRight(scope);
        }

        scope.get(scope.size() - 1).put(varName.toString(), varName);
        System.err.println("added to scope " + scope.size() + " : " + varName.toString());

        if(exp != null) {
            block.addExpressions(exp.getExpressions());
        }
        return block;
    }

    public Expression getExpression() {
        return exp;
    }
}
