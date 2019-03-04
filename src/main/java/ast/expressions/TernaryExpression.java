package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TernaryExpression extends Expression{

    private Expression trueExp;
    private Expression falseExp;
    private Expression cond;

    public TernaryExpression(String file, int line, Expression cond, Expression trueExp, Expression falseExp) {
        super(file, line);
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

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        output.addAll(cond.getExpressions());
//        output.addAll(trueExp.getExpressions());
//        output.addAll(falseExp.getExpressions());
//        output.add(this);
//        return output;
//    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        cond = getScopeId(scope, cond);
        trueExp = getScopeId(scope, trueExp);
        falseExp = getScopeId(scope, falseExp);
    }

    @Override
    public void setUsesAndDefines() {
        setUseAndDefineForChild(cond);
        setUseAndDefineForChild(trueExp);
        setUseAndDefineForChild(falseExp);

        addSource(cond);
        addSource(trueExp);
        addSource(falseExp);
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        //temp1 = condition
        //temp1 ? exp1 : exp2

        cond = cond.transformToTemp(expressions);
        Expression temp = TempCounter.getTempWithExpression(file, line, cond, expressions);

        cond = temp;

        //TODO: how do i deal with the true and false

        return this;
    }
}
