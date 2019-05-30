package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import main.ArgumentHandler;

public class NullLiteral extends Literal {

    public NullLiteral(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof Left && !ArgumentHandler.checkLeft) {
            return 0;
        }
        return o instanceof NullLiteral ? 0 : -1;
    }
}
