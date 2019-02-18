package ast.expressions.left;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeftIdDot extends Left {
    private String id;
    private Expression left;

    public LeftIdDot(int line, String id, Expression left) {
        super(line);
        this.id = id;
        this.left = left;
    }

    @Override
    public void printAST() {
        System.out.println("left id: " + id);
        left.printAST();
    }

    @Override
    public String toString() {
        return left.toString() + "." + id;
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(left.getExpressions());
        output.add(this);
        return output;
    }

    public String getId() {
        return left.toString() + "." + id;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        System.err.println("Set scope id used in leftdot: " + this.toString());
    }

    @Override
    public void setUsesAndDefines() {
        //None
    }
}
