package ast.expressions;

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
}
