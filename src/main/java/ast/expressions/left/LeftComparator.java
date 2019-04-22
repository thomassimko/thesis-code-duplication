package ast.expressions.left;

import java.util.Comparator;

public class LeftComparator implements Comparator<Left> {

    @Override
    public int compare(Left o1, Left o2) {
        return o1.toString().compareTo(o2.toString());
    }
}
