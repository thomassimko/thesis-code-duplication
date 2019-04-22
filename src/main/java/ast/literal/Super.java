package ast.literal;

import ast.expressions.Expression;
import main.ArgumentHandler;

public class Super extends Literal {

    public Super(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "super";
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        return o instanceof Super ? 0 : -1;
    }
}
