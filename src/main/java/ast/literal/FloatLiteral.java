package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import main.ArgumentHandler;

public class FloatLiteral extends Literal {

    private float value;

    public FloatLiteral(String file, int line, float value) {
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
        else if(o instanceof FloatLiteral) {
            if (ArgumentHandler.checkLiterals) {
                return value == ((FloatLiteral) o).value ? 0 : -1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
