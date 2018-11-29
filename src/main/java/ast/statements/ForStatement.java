package ast.statements;

import ast.Declaration;
import ast.expressions.Expression;

import java.util.List;

public class ForStatement extends Statement {

    private Declaration declaration = null;
    private List<Statement> initStatements = null;
    private Expression exp = null;
    private Statement body = null;
    private List<Statement> updateStatements = null;

    public ForStatement(int line, Declaration decl, List<Statement> initStatements, Expression exp, Statement body, List<Statement> updateStatements) {
        super(line);
        this.declaration = decl;
        this.initStatements = initStatements;
        this.exp = exp;
        this.body = body;
        this.updateStatements = updateStatements;
    }

    public void printAST() {
        System.out.println("For");
        declaration.printAST();
        for(Statement stmt: initStatements) {
            stmt.printAST();
        }
        exp.printAST();
        for(Statement stmt: updateStatements) {
            stmt.printAST();
        }
        body.printAST();

    }
}
