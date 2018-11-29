package ast.statements;

import ast.interfaces.BlockStatement;

public abstract class Statement implements BlockStatement {

    int line;

    public Statement(int line) {
        this.line = line;
    }
}
