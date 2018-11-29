package ast.literal;

public class FloatLiteral extends Literal {

    private float value;

    public FloatLiteral(int line, float value) {
        super(line);
        this.value = value;
    }
    @Override
    public void printAST() {
        System.out.println("float: " + value);
    }
}
