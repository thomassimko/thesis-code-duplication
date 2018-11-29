package ast.literal;

public class IntLiteral extends Literal {

    private int value;

    public IntLiteral(int line, int value) {
        super(line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("int: " + value);
    }
}
