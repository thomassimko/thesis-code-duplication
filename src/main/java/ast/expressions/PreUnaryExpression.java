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
    public void printAST() {
        System.out.println("Unary: " + op);
        exp.printAST();
    }

    @Override
    public String toString() {
        return "(++" + exp.toString() + ")";
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
}
