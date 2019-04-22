package ast.literal;

import ast.expressions.Expression;
import main.ArgumentHandler;

import java.util.ArrayList;
import java.util.List;

public class BooleanLiteral extends Literal {

    private boolean value;

    public BooleanLiteral(String file, int line, boolean value) {
        super(file, line);
        this.value = value;
    }

    @Override
    public String toString() {
        return value ? "true" : "false";
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof BooleanLiteral) {
            if (ArgumentHandler.checkLiterals) {
                return value == ((BooleanLiteral) o).value ? 0 : -1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
