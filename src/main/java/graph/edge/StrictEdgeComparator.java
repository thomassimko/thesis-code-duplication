package graph.edge;

import org.jgrapht.graph.DefaultEdge;

import java.util.Comparator;

public class StrictEdgeComparator implements Comparator<DefaultEdge> {


    @Override
    public int compare(DefaultEdge o1, DefaultEdge o2) {

        if(o1 instanceof ControlEdge && o2 instanceof ControlEdge) {
            return 0;
        } else if(o1 instanceof DataEdge && o2 instanceof DataEdge) {
            return 0;
        }
        return -1;
    }
}
