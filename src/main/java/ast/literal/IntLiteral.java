package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import main.ArgumentHandler;

public class IntLiteral extends Literal {

    private int value;

    public IntLiteral(String file, int line, int value) {
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
        else if(o instanceof IntLiteral) {
            if (ArgumentHandler.checkLiterals) {
                return value == ((IntLiteral) o).value ? 0 : -1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
