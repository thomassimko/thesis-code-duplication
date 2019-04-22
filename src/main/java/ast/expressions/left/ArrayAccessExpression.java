package ast.expressions.left;

import ast.expressions.AssignmentExpression;
import ast.expressions.Expression;
import main.ArgumentHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//mark entire array as used/targetted

public class ArrayAccessExpression extends Left {

    private Expression left;
    private List<Expression> accessors;

    public ArrayAccessExpression(String file, int line, Expression left, List<Expression> accessors) {
        super(file, line);
        this.left = left;
        this.accessors = accessors;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(left.toString());
        for (Expression exp : accessors) {
            output.append("[" + exp.toString() + "]");
        }
        return output.toString();
    }

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        output.addAll(left.getExpressions());
//        for (Expression acc : accessors) {
//            output.addAll(acc.getExpressions());
//        }
//        output.add(this);
//        return output;
//    }

    @Override
    public String getId() {
        return left.toString();
    }

    public void setScopeId(List<Map<String, Left>> scope) {
        left = getScopeId(scope, left);
        for(int i = 0; i < accessors.size(); i++) {
            accessors.set(i, getScopeId(scope, accessors.get(i)));
        }
    }

    public Expression getLeft() {
        return left;
    }

    @Override
    public void setUsesAndDefines() {

        for(Expression exp: accessors) {
            setUseAndDefineForChild(exp);
            addSource(exp);
        }
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        for(int i = 0; i < accessors.size(); i++) {
            Expression exp = accessors.get(i);
            accessors.set(i, exp.transformToTemp(expressions));
        }
        return this;
    }

    public int graphicalCompareTo(Expression o) {
        if(ArgumentHandler.checkLeft)
            return o instanceof ArrayAccessExpression ? 0 : -1;
        return 0;
    }
}

