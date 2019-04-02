package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssignmentExpression extends Expression {

    private Expression exp;
    private String operator;
    private Expression left;

    public AssignmentExpression(String file, int line, Expression left, String operator, Expression exp) {
        super(file, line);
        this.left = left;
        this.operator = operator.trim();
        this.exp = exp;
    }

    public Expression getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator + " " + exp.toString();
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        exp = getScopeId(scope, exp);
        left = getScopeId(scope, left);
    }

    public void replaceRight(List<Map<String, Left>> scope) {
        exp = getScopeId(scope, exp);
    }


    @Override
    public void setUsesAndDefines() {

        setUseAndDefineForChild(left);
        setUseAndDefineForChild(exp);

        addTarget(left);
        if(!operator.equals("="))
            addSource(left);
        addSource(exp);
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {

        String newOp = operator.replace("=", "");

        left = left.transformToTemp(expressions);
        exp = exp.transformToTemp(expressions);

        if(!newOp.equals("")) {
            exp = new BinaryExpression(file, this.line, newOp, left, exp);
            operator = "=";
        }

        return this;
    }

    public void setLeft(Expression left) {
        this.left = left;
    }
}
