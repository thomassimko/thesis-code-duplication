package ast.literal;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class BooleanLiteral extends Literal {

    private boolean value;

    public BooleanLiteral(String file, int line, boolean value) {
        super(file, line);
        this.value = value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }
}
