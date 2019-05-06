package main;

import ast.expressions.Expression;
import graph.Mapping;

import java.util.List;
import java.util.Map;

public class OutputFormatter {

    public static void printDuplicates(Mapping mapping) {

        System.out.println(mapping.getKeyFile() + " ----------");

        for(Expression key : mapping.getMap().keySet()) {
            System.out.println(getExpressionString(key));
        }

        System.out.println(mapping.getValueFile() + " ----------");

        for(Expression value : mapping.getMap().values()) {
            if(value != null)
                System.out.println(getExpressionString(value));
            else {
                System.out.println("OBJECT WAS NULL");
            }
        }

        System.out.println("===========================\n\n\n");
    }

    public static void printFilesAndLines(List<Mapping> mappings) {

        for(Mapping mapping : mappings) {

            System.out.println("Duplicate found: " + mapping.toString());

            if(ArgumentHandler.verbose)
                printDuplicates(mapping);
        }
    }

    private static String getExpressionString(Expression exp) {

        return exp.getLine() + " :\t" + exp.toString();

    }

}
