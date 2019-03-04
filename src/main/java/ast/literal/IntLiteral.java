package ast.literal;

public class IntLiteral extends Literal {

    private int value;

    public IntLiteral(String file, int line, int value) {
        super(file, line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("int: " + value);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
