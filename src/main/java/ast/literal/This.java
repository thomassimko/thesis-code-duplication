package ast.literal;

public class This extends Literal {

    public This(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "this";
    }
}
