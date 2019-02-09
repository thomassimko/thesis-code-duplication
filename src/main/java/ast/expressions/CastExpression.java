package ast.expressions;

import java.util.ArrayList;
import java.util.List;

public class CastExpression extends Expression {

    private Expression exp;

    public CastExpression(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    @Override
    public void printAST() {
        System.out.println("CAST");
        exp.printAST();
    }

    @Override
    public String toString() {
        return "(" + exp.toString() + ")";
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(exp.getExpressions());
        output.add(this);
        return output;
    }
}
