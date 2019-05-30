package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import main.ArgumentHandler;

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

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof Left && !ArgumentHandler.checkLeft) {
            return 0;
        }
        else if(o instanceof CharacterLiteral) {
            if (ArgumentHandler.checkLiterals) {
                return value == ((CharacterLiteral) o).value ? 0 : -1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
