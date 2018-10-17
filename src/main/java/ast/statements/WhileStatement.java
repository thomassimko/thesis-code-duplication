package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class WhileStatement implements Statement {

    private Expression exp;
    private Statement stmt;

    public WhileStatement(Expression exp, Statement stmt) {
        this.stmt = stmt;
        this.exp = exp;
    }
}
