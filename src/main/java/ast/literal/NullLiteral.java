package ast.literal;

import ast.expressions.Expression;
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
        return o instanceof NullLiteral ? 0 : -1;
    }
}
