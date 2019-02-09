package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;

public class CallExpression extends Expression {

    //expressionName '.' typeArguments? Identifier '(' argumentList? ')'

    private Expression leftSide;
    private Identifier methodName;
    private List<Expression> argumentList;

    public CallExpression(int line, Identifier methodName, List<Expression> argumentList, Expression leftSide) {
        super(line);
        this.methodName = methodName;
        this.argumentList = argumentList;
        this.leftSide = leftSide;
    }

    @Override
    public void printAST() {
        System.out.println("Call: ");
        if(leftSide != null)
            leftSide.printAST();
        methodName.printAST();
        for(Expression arg: argumentList) {
            arg.printAST();
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if(leftSide != null) {
            output.append(leftSide.toString() + ".");
        }
        output.append(methodName.toString() + "(");
        for(Expression arg: argumentList) {
            output.append(arg.toString() + ", ");
        }
        output.append(')');
        return output.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        if(leftSide != null)
            output.addAll(leftSide.getExpressions());
        for(Expression arg : argumentList) {
            output.addAll(arg.getExpressions());
        }
        output.add(this);
        return output;
    }
}
