package ast.expressions;

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
}
