package graph;

import ast.expressions.Expression;

import java.util.Comparator;

public class ExpressionComparator implements Comparator<Expression> {

    @Override
    public int compare(Expression o1, Expression o2) {

        //Ensure the two objects are not the same
        if(o1.equals(o2)) {
            return -1;
        }
        int out = o1.graphicalCompareTo(o2);
//        if(out == 0) {
//            System.out.println(o1.getLine() + ": " + o1.toString() + " ===== " + o2.getLine() + ": " + o2.toString());
//        }
        return out;
    }
}
