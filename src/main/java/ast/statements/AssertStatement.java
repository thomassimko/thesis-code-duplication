package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class AssertStatement implements Statement {

    private Expression exp;
    private Expression detail;

    public AssertStatement(Expression exp, Expression detail) {
        this.exp = exp;
        this.detail = detail;
    }
}
