package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class ExpressionStatement implements Statement {

    private Expression exp;

    public ExpressionStatement(Expression exp) {
        this.exp = exp;
    }
}
