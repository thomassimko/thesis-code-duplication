package ast.expressions;

import java.util.ArrayList;
import java.util.List;

public class AssignmentExpression extends Expression {

    private Expression exp;
    private String operator;
    private Expression left;

    public AssignmentExpression(int line, Expression left, String operator, Expression exp) {
        super(line);
        this.left = left;
        this.operator = operator;
        this.exp = exp;

        addTarget(left);
    }

    public void printAST() {
        System.out.println("Assignment");
        left.printAST();
        exp.printAST();
    }

    public Expression getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator + " " + exp.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(left.getExpressions());
        output.addAll(exp.getExpressions());
        output.add(this);
        return output;
    }


}
