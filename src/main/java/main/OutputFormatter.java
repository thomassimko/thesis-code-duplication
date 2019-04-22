package main;

import ast.expressions.Expression;

import java.util.List;
import java.util.Map;

public class OutputFormatter {

    public static void printDuplicates(Map<Expression, Expression> mapping) {

        String file1 = mapping.keySet().iterator().next().getFile();
        String file2 = mapping.values().iterator().next().getFile();

        System.out.println(file1 + " ----------");

        for(Expression key : mapping.keySet()) {
            System.out.println(getExpressionString(key));
        }

        System.out.println(file2 + " ----------");

        for(Expression value : mapping.values()) {
            if(value != null)
                System.out.println(getExpressionString(value));
            else {
                System.out.println("OBJECT WAS NULL");
            }
        }

        System.out.println("===========================\n\n\n");
    }

    public static void printFilesAndLines(List<Map<Expression, Expression>> mappings) {

        for(Map<Expression, Expression> mapping : mappings) {

            String file1 = mapping.keySet().iterator().next().getFile();
            String file2 = mapping.values().iterator().next().getFile();

            int min1 = 0;
            int max1 = 0;
            for(Expression key : mapping.keySet()) {
                int line = key.getLine();
                if(line < min1 || min1 == 0) {
                    min1 = line;
                } else if(line > max1) {
                    max1 = line;
                }
            }

            int min2 = 0;
            int max2 = 0;
            for(Expression key : mapping.values()) {
                int line = key.getLine();
                if(line < min2 || min2 == 0) {
                    min2 = line;
                } else if(line > max2) {
                    max2 = line;
                }
            }

            System.out.println("Duplicate found between " + file1 + " lines [" + min1 + ", " + max1 + "] and "
                    + file2 + " lines [" + min2 + ", " + max2 + "]");

            if(ArgumentHandler.verbose)
                printDuplicates(mapping);
        }
    }

    private static String getExpressionString(Expression exp) {

        return exp.getLine() + " :\t" + exp.toString();

    }

}
