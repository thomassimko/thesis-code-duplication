package ast.literal;

public class StringLiteral extends Literal {

    private String value;

    public StringLiteral(String file, int line, String value) {
        super(file, line);
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
