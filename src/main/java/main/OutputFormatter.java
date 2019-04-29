package main;

import ast.expressions.Expression;
import graph.Mapping;

import java.util.List;
import java.util.Map;

public class OutputFormatter {

    public static void printDuplicates(Mapping mapping) {

        StringBuilder keyOut = new StringBuilder();
        keyOut.append(mapping.getKeyFile() + " ----------");
        keyOut.append("\n");

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

//            String file1 = mapping.keySet().iterator().next().getFile();
//            String file2 = mapping.values().iterator().next().getFile();
//
//            int min1 = 0;
//            int max1 = 0;
//            for(Expression key : mapping.keySet()) {
//                int line = key.getLine();
//                if(line < min1 || min1 == 0) {
//                    min1 = line;
//                } else if(line > max1) {
//                    max1 = line;
//                }
//            }
//
//            int min2 = 0;
//            int max2 = 0;
//            for(Expression key : mapping.values()) {
//                int line = key.getLine();
//                if(line < min2 || min2 == 0) {
//                    min2 = line;
//                } else if(line > max2) {
//                    max2 = line;
//                }
//            }

            System.out.println("Duplicate found: " + mapping.toString());

            if(ArgumentHandler.verbose)
                printDuplicates(mapping);
        }
    }

    private static String getExpressionString(Expression exp) {

        return exp.getLine() + " :\t" + exp.toString();

    }

}
