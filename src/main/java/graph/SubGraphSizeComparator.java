package graph;

import ast.expressions.Expression;
import java.util.Comparator;
import java.util.Map;

public class SubGraphSizeComparator implements Comparator<Mapping> {

    @Override
    public int compare(Mapping o1, Mapping o2) {
        return o2.getSize() - o1.getSize();
    }
}
