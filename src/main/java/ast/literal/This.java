package ast.literal;

import ast.expressions.Expression;

public class This extends Literal {

    public This(String file, int line) {
        super(file, line);
    }

    @Override
    public String toString() {
        return "this";
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        return o instanceof This ? 0 : -1;
    }
}
