package ast.expressions;

import ast.expressions.left.Left;
import ast.literal.IntLiteral;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreUnaryExpression extends Expression {

    private String op;
    private Expression exp;

    public PreUnaryExpression(String file, int line, String op, Expression exp) {
        super(file, line);
        this.op = op;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "(++" + exp.toString() + ")";
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        exp = getScopeId(scope, exp);
    }

    @Override
    public void setUsesAndDefines() {
        setUseAndDefineForChild(exp);
        addTarget(exp);
        addSource(exp);
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        String plusMinus = op.equals("++") ? "+" : "-";

        exp = exp.transformToTemp(expressions);

        BinaryExpression bin = new BinaryExpression(file, line, plusMinus, exp, new IntLiteral(file, line, 1));
        AssignmentExpression asgn = new AssignmentExpression(file, line, exp, "=", bin);

        expressions.add(asgn);

        return exp;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        System.err.println("FOUND PRE UNARY COMPARE TO EXPRESSION");
        return 0;
    }
}
