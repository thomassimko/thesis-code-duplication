package graph;

import ast.expressions.Expression;
import main.ArgumentHandler;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import java.util.*;

public class GraphComparison {

    public static List<Mapping> compareGraphs(List<Expression> expressions) {

        PriorityQueue<Mapping> mappings = new PriorityQueue<Mapping>(10, new SubGraphSizeComparator());
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
        List<Mapping> filteredMappings = filterMappings(mappings);
        System.out.println("Filtered: " + filteredMappings.size() + "\n\n");

        return filteredMappings;
    }

    private static List<Mapping> filterMappings(PriorityQueue<Mapping> mappings) {
        List<Mapping> filteredMapList = new ArrayList<>();
        List<Mapping> mapListMask = new ArrayList<>();

        while(mappings.size() > 0) {
            Mapping map = mappings.poll();
            boolean isSubMap = false;

            Set<Expression> keys = new HashSet<>();
            Set<Expression> values = new HashSet<>();

            for(Map.Entry<Expression, Expression> entry: map.getMap().entrySet()) {
                keys.add(entry.getKey());
                values.add(entry.getValue());
//                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            //Check if the keys and values overlap
            loop:
            for(Expression key : keys) {
                for(Expression value : values) {
                    if(key.getFile().equals(value.getFile()) && key.getLine() == value.getLine()) {
                        isSubMap = true;
                        break loop;
                    }
                }
            }

            //if one is a subset of the other map
            for (int i = 0; i < filteredMapList.size() && !isSubMap; i++) {

                Mapping filteredMap = filteredMapList.get(i);
                if (filteredMap.isSubMapping(map)) {
                    isSubMap = true;
                }
            }

            if(!isSubMap) {
                filteredMapList.add(map);

                //add the list to the mask
                mapListMask.add(map);
                //add the reversed list to the mask
                mapListMask.add(map.getReverse());
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
