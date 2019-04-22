package ast.literal;

import ast.expressions.Expression;
import main.ArgumentHandler;

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

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof StringLiteral) {
            if (ArgumentHandler.checkLiterals) {
                return value.equals(((StringLiteral) o).value) ? 0 : -1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
