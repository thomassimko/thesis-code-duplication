package ast.statements;

import ast.Declaration;
import ast.interfaces.Statement;

public class DeclarationStatement implements Statement {
    private Declaration decl;
    private Statement stmt;

    public DeclarationStatement(Declaration decl, Statement stmt) {

    }
}
