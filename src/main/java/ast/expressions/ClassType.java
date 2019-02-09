package ast.expressions;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return className + ".class";
    }
}
