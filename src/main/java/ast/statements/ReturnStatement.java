package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class ReturnStatement implements Statement {

    private Expression exp;

    public ReturnStatement(Expression exp) {
        this.exp = exp;
    }
}
