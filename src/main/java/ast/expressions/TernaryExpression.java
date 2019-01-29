package ast.expressions;

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
}