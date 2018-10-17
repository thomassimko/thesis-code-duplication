package ast.statements;

import ast.interfaces.Statement;

public class BreakStatement implements Statement {

    private String id;

    public BreakStatement() {

    }

    public BreakStatement(String id) {
        this.id = id;
    }
}
