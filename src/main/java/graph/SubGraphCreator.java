package graph;

import ast.expressions.Expression;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class SubGraphCreator {

    public static DefaultDirectedGraph<Expression, DefaultEdge> generateGraph(Expression head, Set<Expression> visited) {

        LinkedList<Expression> queue = new LinkedList<>();

        DefaultDirectedGraph<Expression, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);
        graph.addVertex(head);

        queue.push(head);

        Expression cur = null;

        while(!queue.isEmpty()) {
            cur = queue.pop();

            if (!visited.contains(cur)) {
                visited.add(cur);

                if(!graph.containsVertex(cur)) {
                    graph.addVertex(cur);
                }

                List<Expression> depend = new ArrayList<>();
                depend.addAll(cur.getDataDependents());
                depend.addAll(cur.getWawDependents());
                for (Expression exp : depend) {

                    if (!graph.containsVertex(exp)) {
                        graph.addVertex(exp);
                    }
                    graph.addEdge(cur, exp);

                    queue.add(exp);
                    queue.addAll(exp.getDependentOn());

                }

            }
        }
        return graph;
    }




}
