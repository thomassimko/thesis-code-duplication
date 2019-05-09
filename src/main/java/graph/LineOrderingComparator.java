package graph;

import ast.expressions.Expression;

import java.util.Comparator;

public class LineOrderingComparator implements Comparator<Expression> {

    @Override
    public int compare(Expression o1, Expression o2) {
        if(o1.getLine() - o2.getLine() == 0) {
            return -1;
        }
        return o1.getLine() - o2.getLine();
    }
}
