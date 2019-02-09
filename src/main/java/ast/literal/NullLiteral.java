package ast.literal;

public class NullLiteral extends Literal {

    public NullLiteral(int line) {
        super(line);
    }

    @Override
    public void printAST() {
        System.out.println("null");
    }

    @Override
    public String toString() {
        return "null";
    }
}
