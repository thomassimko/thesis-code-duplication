package graph;

import ast.expressions.Expression;
import java.util.Comparator;
import java.util.Map;

public class SubGraphSizeComparator implements Comparator<Map<Expression, Expression>> {

    @Override
    public int compare(Map<Expression, Expression> o1, Map<Expression, Expression> o2) {
        return o2.size() - o1.size();
    }
}
