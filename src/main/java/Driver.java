import ast.Program;
import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;
import org.antlr.v4.runtime.*;

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

    public static void main(String[] args) {

        try {
            CharStream stream = CharStreams.fromFileName(args[0]);
            Java8Lexer lexer = new Java8Lexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Java8Parser parser = new Java8Parser(tokens);
            ParserRuleContext tree = parser.compilationUnit(); // parse

            MyVisitor visitor = new MyVisitor();
            Program program = visitor.visit(tree);
            //program.printProgram();

            //program.printProgram();
            List<StartBlock> starts = program.getCFG();
            List<CFGBlock> allBlocks = new ArrayList<CFGBlock>();
            printCFG(starts);

            generateReachingDefinitions(allBlocks, starts);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printCFG(List<StartBlock> blockList) {
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

    private static void generateReachingDefinitions(List<CFGBlock> allBlocks, List<StartBlock> starts) {
        for(StartBlock start : starts) {
            allBlocks.add(start);
            allBlocks.addAll(start.getMethodBlocks());
            for(CFGBlock block : start.getMethodBlocks()) {
                block.setTargetsAndSources();
                block.printTargets();
                block.printSources();
                System.out.println();
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
    }
}
