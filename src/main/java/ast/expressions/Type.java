package ast.expressions;

import ast.expressions.Expression;

public class Type extends Expression {

    private String type;

    public Type(int line, String type) {
        super(line);
        this.type = type;
    }

    @Override
    public void printAST() {
        System.out.println("Type: " + type);
    }
}
