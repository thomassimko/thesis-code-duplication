package ast.literal;

public class CharacterLiteral extends Literal {

    private char value;

    public CharacterLiteral(String file, int line, char value) {
        super(file, line);
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
