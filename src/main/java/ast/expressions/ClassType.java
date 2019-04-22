package ast.expressions;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassType extends Expression {

    private String className;

    public ClassType(String file, int line, String className) {
        super(file, line);
        this.className = className;
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

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return this;
    }

    public int graphicalCompareTo(Expression o) {
        if(o instanceof ClassType) {
            ClassType other = (ClassType) o;
            return other.className.compareTo(className);
        }
        return -1;
    }
}
