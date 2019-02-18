package ast.expressions;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //do nothing
    }

    @Override
    public void setUsesAndDefines() {
        //nothing
    }
}
