package ast.expressions;

import java.util.ArrayList;
import java.util.List;

public class TernaryExpression extends Expression{

    private Expression trueExp;
    private Expression falseExp;
    private Expression cond;

    public TernaryExpression(int line, Expression cond, Expression trueExp, Expression falseExp) {
        super(line);
        this.cond = cond;
        this.trueExp = trueExp;
        this.falseExp = falseExp;

    }

    @Override
    public void printAST() {
        System.out.println("Ternary:");
        cond.printAST();
        trueExp.printAST();
        falseExp.printAST();
    }

    @Override
    public String toString() {
        return cond.toString() + " ? " + trueExp.toString() + " : " + falseExp.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.addAll(cond.getExpressions());
        output.addAll(trueExp.getExpressions());
        output.addAll(falseExp.getExpressions());
        output.add(this);
        return output;
    }
}
