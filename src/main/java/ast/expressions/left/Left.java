package ast.expressions.left;

import ast.expressions.Expression;

public abstract class Left extends Expression implements Comparable<Left> {

    public Left(String file, int line) {
        super(file, line);
    }

    public boolean equalsId(Left obj1) {
        return this.getId().equals(obj1.getId());
    }

    public abstract String getId();

    @Override
    public int compareTo(Left o) {
        return this.toString().compareTo(o.toString());
    }
}
