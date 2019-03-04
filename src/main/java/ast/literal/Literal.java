package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.List;
import java.util.Map;

public abstract class Literal extends Expression {

    int line;

    public Literal(String file, int line) {
        super(file, line);
        this.line = line;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //do nothing
    }

    @Override
    public void setUsesAndDefines() {
        //do nithing
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return this;
    }
}
