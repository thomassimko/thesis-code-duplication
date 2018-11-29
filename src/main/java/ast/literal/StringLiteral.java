package ast.literal;

public class StringLiteral extends Literal {

    private String value;

    public StringLiteral(int line, String value) {
        super(line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("String: " + value);
    }
}
