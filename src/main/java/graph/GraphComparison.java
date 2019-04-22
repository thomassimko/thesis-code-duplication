package graph;

import ast.expressions.Expression;
import main.ArgumentHandler;
import main.OutputFormatter;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;
import java.util.stream.Collectors;

public class GraphComparison {

    public static List<Map<Expression, Expression>> compareGraphs(List<Expression> expressions) {

        PriorityQueue<Map<Expression, Expression>> mappings = new PriorityQueue<>(10, new SubGraphSizeComparator());
        List<Graph<Expression, DefaultEdge>> graphList = generateLargeGraphs(expressions);

        //Generate the mappings
        for(Expression exp : expressions) {

            //Create a new seen for each expression
//            Set<Set<Expression>> seenSubgraphs = new HashSet<>();

            //Traverse all of the large graphs
            for(Graph<Expression, DefaultEdge> largeGraph : graphList) {

                //Create a new seen for each expression
                Set<Set<Expression>> seenSubgraphs = new HashSet<>();

                //setup list and subgraph obj
                List<Expression> added = new ArrayList<>();
                added.add(exp);

                //Create a new subgraph for each large graph and compare
                Graph<Expression, DefaultEdge> subgraph = new DefaultDirectedGraph<>(DefaultEdge.class);
                subgraph.addVertex(exp);

                IsomorphismFinder.findSubgraphs(subgraph, largeGraph, added, seenSubgraphs, mappings);
            }
        }
        System.out.println("Unfiltered: " + mappings.size());
        List<Map<Expression, Expression>> filteredMappings = filterMappings(mappings);
        System.out.println("Filtered: " + filteredMappings.size() + "\n\n");

        return filteredMappings;
    }

    private static List<Map<Expression, Expression>> filterMappings(PriorityQueue<Map<Expression, Expression>> mappings) {
        List<Map<Expression, Expression>> filteredMapList = new ArrayList<>();
        List<Map<Expression, Expression>> mapListMask = new ArrayList<>();

        while(mappings.size() > 0) {
            Map<Expression, Expression> map = mappings.poll();
            boolean isSubMap = false;
            //System.out.println(map.size());

            //if one is a subset of the other map
            for(Map<Expression, Expression> filteredMap : mapListMask) {
                if(filteredMap.entrySet().containsAll(map.entrySet())) {
                    isSubMap = true;
                    break;
                }
            }

            if(!isSubMap) {
                filteredMapList.add(map);

                //add the list to the mask
                mapListMask.add(map);
                //add the reversed list to the mask
                mapListMask.add(map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey)));
            }
        }
        return filteredMapList;
    }

    private static List<Graph<Expression, DefaultEdge>> generateLargeGraphs(List<Expression> expressions) {
        Set<Expression> visitedLarge = new HashSet<>();
        List<Graph<Expression, DefaultEdge>> graphList = new ArrayList<>();

        //generate all of the large subgraphs of minimum size
        for (Expression exp : expressions) {

            if (!visitedLarge.contains(exp)) {
                Graph<Expression, DefaultEdge> g = SubGraphCreator.generateGraph(exp, visitedLarge);
                if (g.vertexSet().size() >= ArgumentHandler.minGraphSize) {
                    graphList.add(g);
                }

            }
        }

        return graphList;
    }
}
