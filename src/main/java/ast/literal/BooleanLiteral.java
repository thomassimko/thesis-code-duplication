package ast.literal;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class BooleanLiteral extends Literal {

    private boolean value;

    public BooleanLiteral(int line, boolean value) {
        super(line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("boolean: " + value);
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }
}
