package ast.literal;

public class Super extends Literal {

    public Super(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "super";
    }
}
