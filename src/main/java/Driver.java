import ast.Program;
import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;
import graph.GraphComparison;
import graph.IsomorphismFinder;
import graph.SubGraphCreator;
import graph.SubGraphSizeComparator;
import main.ArgumentHandler;
import main.OutputFormatter;
import org.jgrapht.Graph;
import org.jgrapht.GraphMapping;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Driver {

    static final MyStatementVisitor statementVisitor = new MyStatementVisitor();
    static final MyClassDeclarationVisitor classDeclarationVisitor = new MyClassDeclarationVisitor();
    static final MyDeclarationVisitor declarationVisitor = new MyDeclarationVisitor();
    static final MyExpressionVisitor expressionVisitor = new MyExpressionVisitor();
    static final MyBlockVisitor blockVisitor = new MyBlockVisitor();
    static final MySwitchStatementVisitor switchStatementVisitor = new MySwitchStatementVisitor();
    static final MyMethodVisitor methodVisitor = new MyMethodVisitor();
    static final MyLeftHandSideVisitor leftHandSideVisitor = new MyLeftHandSideVisitor();
    static final MyTypeDeclarationVisitor typeVisitor = new MyTypeDeclarationVisitor();
    static final MyPrimaryVisitor primaryVisitor = new MyPrimaryVisitor();
    static final MyLiteralVisitor literalVisitor = new MyLiteralVisitor();

    static String currentFileName = null;
    static boolean checkLiterals = false;

    public static void main(String[] args) {

        String directory = args[0];

        List<Map<Expression, Expression>> mappings = Driver.run(directory);

        OutputFormatter.printFilesAndLines(mappings);

    }

    public static List<Map<Expression, Expression>> run(String directoy) {
        Program program = FileParser.parseFiles(directoy);

        List<StartBlock> starts = program.getCFG();
        List<CFGBlock> allBlocks = new ArrayList<CFGBlock>();
        List<Expression> allExp = new ArrayList<>();

        for(StartBlock start: starts) {
            allBlocks.addAll(start.getMethodBlocks());
        }
        for(CFGBlock block: allBlocks) {
            allExp.addAll(block.getExpressions());
        }

        graphCFG(starts);
        writeExpressionsToFile(allBlocks);

        generateReachingDefinitions(allBlocks, starts);
        printReachingDefinitions(allBlocks);

        printPDG(starts);

        return GraphComparison.compareGraphs(allExp);
    }

    private static void graphCFG(List<StartBlock> blockList) {
        try {
            FileWriter writer = new FileWriter(new File("cfg.gv"));
            StringBuilder nodes = new StringBuilder();
            Set<CFGBlock> visitedBlocks = new HashSet<CFGBlock>();

            writer.write("digraph G {\n");
            writer.write("size =\"8.5,11\";\n");

            for (CFGBlock block : blockList) {
                block.getGraphVisFormat(visitedBlocks, nodes);
            }
            writer.write(nodes.toString());
            writer.write("}");

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void writeExpressionsToFile(List<CFGBlock> allBlocks) {
        try {
            FileWriter writer = new FileWriter(new File("expressions.txt"));

            for(CFGBlock block: allBlocks) {
                if(block instanceof StartBlock) {
                    StartBlock start = (StartBlock) block;
                    writer.write("function " + start.getFunctionName() + " from class ");
                    writer.write(start.getClassName() + "\n");
                }
                for(Expression exp : block.getExpressions()) {
                    writer.write(exp.toString() + "\n");
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    private static void generateReachingDefinitions(List<CFGBlock> allBlocks, List<StartBlock> starts) {
        for(StartBlock start : starts) {
            allBlocks.add(start);
            allBlocks.addAll(start.getMethodBlocks());
            for(CFGBlock block : start.getMethodBlocks()) {
                block.setTargetsAndSources();
            }
        }

        for(CFGBlock block: allBlocks) {
            block.setGenKillSet();
        }
        Queue<CFGBlock> changed = new LinkedList<>(allBlocks);

        while(!changed.isEmpty()) {
            CFGBlock cur = changed.remove();
            cur.setLiveOut(changed);
        }

        for(CFGBlock block: allBlocks) {
            block.setDependents();
        }
    }

    private static void printReachingDefinitions(List<CFGBlock> allBlocks) {
        for(CFGBlock block : allBlocks) {
            System.out.println("BLOCK: " + block.getLabel());
            HashMap<Left, Set<Expression>> lo = block.getLiveOut();
            for(Left key: lo.keySet()) {
                System.out.print(key.toString() + " : ");
                for(Expression exp: lo.get(key)) {
                    System.out.print(exp.toString() + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static void printPDG(List<StartBlock> methods) {

        try {

            for (StartBlock method : methods) {

                String path = method.getFile();
                String fileName = path.replace(".java", "") + "-" + method.getFunctionName() + ".gv";
                String dir = new File("pdg/source/" + fileName).getParent();
                new File(dir).mkdirs();
                FileWriter writer = new FileWriter(new File("pdg/source/" + fileName));

                writer.write("digraph G {\n");

                for(CFGBlock block : method.getMethodBlocks()) {
                    for (Expression exp : block.getExpressions()) {
                        writer.write(exp.toGraphVis() + "\n");
                        for(Expression dependent : exp.getDataDependents()) {
                            writer.write(exp.toGraphVis() + " -> " + dependent.toGraphVis() + "\n");
                        }
                        for(Expression dependent : exp.getWawDependents()) {
                            writer.write(exp.toGraphVis() + " -> " + dependent.toGraphVis() + " [style=dashed]\n");
                        }
                    }
                }

                writer.write("}");

                writer.flush();
                writer.close();
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
