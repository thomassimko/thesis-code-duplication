package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CallExpression extends Expression {

    //expressionName '.' typeArguments? Identifier '(' argumentList? ')'

    private Expression leftSide;
    private Identifier methodName;
    private List<Expression> argumentList;

    public CallExpression(String file, int line, Identifier methodName, List<Expression> argumentList, Expression leftSide) {
        super(file, line);
        this.methodName = methodName;
        this.argumentList = argumentList;
        this.leftSide = leftSide;
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

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        if(leftSide != null)
//            output.addAll(leftSide.getExpressions());
//        for(Expression arg : argumentList) {
//            output.addAll(arg.getExpressions());
//        }
//        output.add(this);
//        return output;
//    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        leftSide = getScopeId(scope, leftSide);
        for(int i = 0; i < argumentList.size(); i++) {
            argumentList.set(i, getScopeId(scope, argumentList.get(i)));
        }
    }

    @Override
    public void setUsesAndDefines() {
        for(Expression arg: argumentList) {
            setUseAndDefineForChild(arg);
            addSource(arg);
        }
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        if(leftSide != null)
            leftSide = leftSide.transformToTemp(expressions);
        for(int i = 0; i < argumentList.size(); i++) {
            Expression arg = argumentList.get(i);
            argumentList.set(i, arg.transformToTemp(expressions));
        }
        return this;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof CallExpression) {
            CallExpression call = (CallExpression) o;
            if(methodName.graphicalCompareTo(call.methodName) == 0) {
                if(argumentList.size() != call.argumentList.size())
                    return -1;
                else
                    for(int i = 0; i < argumentList.size(); i++) {
                        if(argumentList.get(i).graphicalCompareTo(call.argumentList.get(i)) != 0) {
                            return -1;
                        }
                    }
                return 0;
            }
        }
        return -1;
    }
}
