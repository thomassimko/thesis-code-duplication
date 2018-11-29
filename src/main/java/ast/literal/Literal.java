package ast.literal;

import ast.expressions.Expression;

public abstract class Literal extends Expression {

    int line;

    public Literal(int line) {
        super(line);
        this.line = line;
    }

}
