package ast.expressions;

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
}
