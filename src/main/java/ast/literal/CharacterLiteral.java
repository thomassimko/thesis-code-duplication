package ast.literal;

public class CharacterLiteral extends Literal {

    private char value;

    public CharacterLiteral(int line, char value) {
        super(line);
        this.value = value;
    }

    @Override
    public void printAST() {
        System.out.println("char: " + value);
    }
}
