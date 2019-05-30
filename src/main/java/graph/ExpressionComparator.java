package graph;

import ast.expressions.Expression;

import java.util.Comparator;

public class ExpressionComparator implements Comparator<Expression> {

    @Override
    public int compare(Expression o1, Expression o2) {

        //Ensure the two objects are not the same
        if(o1 == o2) {
            return -1;
        }
        return o1.graphicalCompareTo(o2);
    }
}
