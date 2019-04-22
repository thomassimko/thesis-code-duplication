package graph;

import ast.expressions.Expression;
import main.ArgumentHandler;
import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.alg.isomorphism.VF2AbstractIsomorphismInspector;
import org.jgrapht.alg.isomorphism.VF2GraphIsomorphismInspector;
import org.jgrapht.alg.isomorphism.VF2SubgraphIsomorphismInspector;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class IsomorphismFinder {

    public static void findSubgraphs(Graph<Expression, DefaultEdge> subgraph, Graph<Expression, DefaultEdge> largeGraph, List<Expression> added, Set<Set<Expression>> seenGraphs, PriorityQueue<Map<Expression, Expression>> mappings) {

        //get all of the outgoing/incoming vertices minus the ones already in the graph
        Set<Expression> possibleNext = new HashSet<>();
        for(Expression exp: added) {
            possibleNext.addAll(exp.getDataDependents());
            possibleNext.addAll(exp.getWawDependents());
            possibleNext.addAll(exp.getDependentOn());
        }
        possibleNext.removeAll(added);

        //for each expression, add it to the graph and then check isomorphism and the recursively call
        Iterator<Expression> iter = possibleNext.iterator();
        while(iter.hasNext()) {


            Expression newExp = iter.next();

            added.add(newExp);
            addExpressionToGraph(subgraph, newExp);

            if(subgraph.vertexSet().size() <= largeGraph.vertexSet().size()) {

                if (subgraph.vertexSet().size() >= ArgumentHandler.minGraphSize) {
                    if (haveSeenGraph(subgraph, seenGraphs)) {
                        continue;
                    }

                    //check if exp is isomorphism
                    VF2AbstractIsomorphismInspector iso = new VF2SubgraphIsomorphismInspector(largeGraph, subgraph, new ExpressionComparator(), null, true);

                    if (iso.isomorphismExists()) {

                        Iterator<GraphMapping<Expression, DefaultEdge>> mappingIter = iso.getMappings();


                        //DO I ONLY CARE ABOUT 1 MAPPING?
                        while (mappingIter.hasNext()) {

                            Map<Expression, Expression> newMapping = new HashMap<>();

                            GraphMapping<Expression, DefaultEdge> mapping = mappingIter.next();

                            for (Expression exp : added) {
                                Expression corresponding = mapping.getVertexCorrespondence(exp, false);
                                if(corresponding != null)
                                    newMapping.put(exp, corresponding);
                            }
                            mappings.add(newMapping);
                        }

                    }
                }


                findSubgraphs(subgraph, largeGraph, added, seenGraphs, mappings);
            }

            added.remove(newExp);
            subgraph.removeVertex(newExp);

        }


    }


    private static void addExpressionToGraph(Graph<Expression, DefaultEdge> subgraph, Expression newExp) {
        subgraph.addVertex(newExp);

        List<Expression> dependents = new ArrayList<>();
        dependents.addAll(newExp.getDataDependents());
        dependents.addAll(newExp.getWawDependents());
        for(Expression dep : dependents) {
            if(subgraph.containsVertex(dep)) {
                subgraph.addEdge(newExp, dep);
            }
        }

        for(Expression exp: newExp.getDependentOn()) {
            if(subgraph.containsVertex(exp)) {
                subgraph.addEdge(exp, newExp);
            }
        }
    }

    private static boolean haveSeenGraph(Graph<Expression, DefaultEdge> graph, Set<Set<Expression>> seenList) {

        Set<Expression> graphVertices = new HashSet<>(graph.vertexSet());

        Iterator<Set<Expression>> iter = seenList.iterator();

        while(iter.hasNext()) {
            Set<Expression> seen = iter.next();
            //if the two graphs are equal
            if (graphVertices.containsAll(seen) && seen.containsAll(graphVertices)) {
                //System.out.println("SEEN!");
                return true;
            }
        }
        //System.out.println("NOT SEEN!");
        seenList.add(graphVertices);
        return false;
    }
}
