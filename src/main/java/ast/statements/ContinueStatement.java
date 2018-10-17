package ast.statements;

import ast.interfaces.Statement;

public class ContinueStatement implements Statement {

    private String id;

    public ContinueStatement() {

    }

    public ContinueStatement(String id) {
        this.id = id;
    }
}
