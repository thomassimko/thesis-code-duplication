package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CastExpression extends Expression {

    private Expression exp;

    public CastExpression(String file, int line, Expression exp) {
        super(file, line);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "(" + exp.toString() + ")";
    }

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        output.addAll(exp.getExpressions());
//        output.add(this);
//        return output;
//    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        exp = getScopeId(scope, exp);
    }

    @Override
    public void setUsesAndDefines() {
        setUseAndDefineForChild(exp);
        addSource(exp);
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return exp = exp.transformToTemp(expressions);
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        System.err.println("FOUND CAST COMPARE TO EXPRESSION");
        return 0;
    }
}
