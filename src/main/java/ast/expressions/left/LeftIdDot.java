package ast.expressions.left;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeftIdDot extends Left {
    private String id;
    private Expression left;

    public LeftIdDot(String file, int line, String id, Expression left) {
        super(file, line);
        this.id = id;
        this.left = left;
    }

    @Override
    public String toString() {
        return left.toString() + "." + id;
    }

    public String getId() {
        return left.toString() + "." + id;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //System.err.println("Set scope id used in leftdot: " + this.toString());
    }

    @Override
    public void setUsesAndDefines() {
        //None
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        left = left.transformToTemp(expressions);
        return this;
    }
}
