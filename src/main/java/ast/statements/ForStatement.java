package ast.statements;

import ast.Declaration;
import ast.interfaces.Expression;
import ast.interfaces.Statement;

import java.util.List;

public class ForStatement implements Statement {

    private Declaration declaration = null;
    private List<Statement> initStatements = null;
    private Expression exp = null;
    private Statement body = null;
    private List<Statement> updateStatements = null;

    public ForStatement(Declaration decl, List<Statement> initStatements, Expression exp, Statement body, List<Statement> updateStatements) {
        this.declaration = decl;
        this.initStatements = initStatements;
        this.exp = exp;
        this.body = body;
        this.updateStatements = updateStatements;
    }
}
