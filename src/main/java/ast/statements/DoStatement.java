package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class DoStatement implements Statement {
    private Statement stmt;
    private Expression exp;

    public DoStatement(Statement stmt, Expression exp) {
        this.stmt = stmt;
        this.exp = exp;
    }
}
