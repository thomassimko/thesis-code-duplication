package ast.literal;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class Array extends Literal {

    private List<Expression> expressionList;

    public Array(int line, List<Expression> values) {
        super(line);
        this.expressionList = values;
    }

    @Override
    public void printAST() {
        System.out.println("Array: ");
        for (Expression exp : expressionList) {
            exp.printAST();
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append('{');
        for(Expression exp: expressionList) {
            output.append(exp.toString() + ", ");
        }
        output.append('}');
        return output.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        for(Expression exp: expressionList) {
            output.addAll(exp.getExpressions());
        }
        output.add(this);
        return output;
    }
}
