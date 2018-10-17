package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class ThrowStatement implements Statement {

    private Expression exp;

    public ThrowStatement(Expression exp) {
        this.exp = exp;
    }
}
