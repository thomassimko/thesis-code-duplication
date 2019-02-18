package ast.expressions.left;

import ast.expressions.Expression;

public abstract class Left extends Expression {

    public Left(int line) {
        super(line);
    }

    public boolean equalsId(Left obj1) {
        return this.getId().equals(obj1.getId());
    }

    public abstract String getId();
}
