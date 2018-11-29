package ast.expressions;

public class LeftIdDot extends Expression {
    private String id;
    private Expression left;

    public LeftIdDot(int line, String id, Expression left) {
        super(line);
        this.id = id;
        this.left = left;
    }

    @Override
    public void printAST() {
        System.out.println("left id: " + id);
        left.printAST();
    }
}
