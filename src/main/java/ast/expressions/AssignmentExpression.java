package ast.expressions;

public class AssignmentExpression extends Expression {

    private Expression exp;
    private String operator;
    private Expression left;

    public AssignmentExpression(int line, Expression left, String operator, Expression exp) {
        super(line);
        this.left = left;
        this.operator = operator;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Assignment");
        left.printAST();
        exp.printAST();
    }
}
