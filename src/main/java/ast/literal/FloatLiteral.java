package ast.literal;

public class FloatLiteral extends Literal {

    private float value;

    public FloatLiteral(String file, int line, float value) {
        super(file, line);
        this.value = value;
    }
    @Override
    public void printAST() {
        System.out.println("float: " + value);
    }

    @Override
    public String toString() {
        return value + "";
    }
}
