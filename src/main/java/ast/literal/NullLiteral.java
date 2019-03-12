package ast.literal;

public class NullLiteral extends Literal {

    public NullLiteral(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "null";
    }
}
