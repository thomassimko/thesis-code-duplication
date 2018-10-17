package ast.statements;

import ast.interfaces.Statement;

public class LabeledStatement implements Statement {

    private String label;
    private Statement stmt;

    public LabeledStatement(String label, Statement stmt) {
        this.label = label;
        this.stmt = stmt;
    }
}
