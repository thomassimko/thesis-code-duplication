package ast.literal;

public class BooleanLiteral extends Literal {

    private boolean value;

    public BooleanLiteral(int line, boolean value) {
        super(line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("boolean: " + value);
    }
}
