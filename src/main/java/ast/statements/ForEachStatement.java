package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class ForEachStatement implements Statement {

    private Expression exp;
    private Statement body;
    private String declaredId = null;

    public ForEachStatement(Expression exp, Statement body, String declaredId) {
        this.exp = exp;
        this.declaredId = declaredId;
        this.body = body;
    }
}
