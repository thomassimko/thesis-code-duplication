package ast.expressions;

public class BinaryExpression extends Expression {

    private String operator;
    private Expression left;
    private Expression right;

    public BinaryExpression(int line, String operator, Expression left, Expression right) {
        super(line);
        this.operator = operator;
        this.left = left;
        this.right = right;

    }

    @Override
    public void printAST() {
        System.out.println("Binary Exp: " + operator);
        left.printAST();
        right.printAST();
    }
}
