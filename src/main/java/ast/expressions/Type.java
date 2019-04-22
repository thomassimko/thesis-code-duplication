package ast.expressions;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Type extends Expression {

    private String type;

    public Type(String file, int line, String type) {
        super(file, line);
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //do nothing
    }

    @Override
    public void setUsesAndDefines() {

    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return this;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof Type) {
            return type.compareTo(((Type) o).type);
        }
        return -1;
    }
}
