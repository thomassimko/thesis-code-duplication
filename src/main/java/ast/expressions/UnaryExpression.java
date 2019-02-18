package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnaryExpression extends Expression {

    private String op;
    private Expression exp;

    public UnaryExpression(int line, String op, Expression exp) {
        super(line);
        this.op = op;
        this.exp = exp;
    }

    @Override
    public void printAST() {
        System.out.println("Unary: " + op);
        exp.printAST();
    }

    @Override
    public String toString() {
        return op + exp.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(exp.getExpressions());
        output.add(this);
        return output;
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        exp = getScopeId(scope, exp);
    }

    @Override
    public void setUsesAndDefines() {
        addSource(exp);
    }
}
