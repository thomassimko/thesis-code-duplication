package ast.expressions;

import ast.expressions.left.Left;
import ast.literal.BooleanLiteral;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnaryExpression extends Expression {

    private String op;
    private Expression exp;

    public UnaryExpression(String file, int line, String op, Expression exp) {
        super(file, line);
        this.op = op;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return op + exp.toString();
    }

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
        exp = exp.transformToTemp(expressions);
        return exp;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof UnaryExpression) {
            UnaryExpression unary = (UnaryExpression) o;
            if(op.compareTo(unary.op) == 0) {
                return exp.graphicalCompareTo(unary.exp);
            }
        }
        return 0;
    }
}
