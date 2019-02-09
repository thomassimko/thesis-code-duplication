package ast.expressions;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

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
}
