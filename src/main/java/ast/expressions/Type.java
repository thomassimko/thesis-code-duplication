package ast.expressions;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public String toString() {
        return type;
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.add(this);
        return output;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //do nothing
    }

    @Override
    public void setUsesAndDefines() {

    }
}
