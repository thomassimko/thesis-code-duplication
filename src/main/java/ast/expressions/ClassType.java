package ast.expressions;

import ast.expressions.Expression;

public class ClassType extends Expression {

    private String className;

    public ClassType(int line, String className) {
        super(line);
        this.className = className;
    }

    @Override
    public void printAST() {
        System.out.println("Classname: " + className);
    }
}
