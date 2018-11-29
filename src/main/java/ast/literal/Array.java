package ast.literal;

import ast.expressions.Expression;

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
}
