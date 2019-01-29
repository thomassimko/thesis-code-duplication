import ast.Program;
import cfg.CFGBlock;
import cfg.StartBlock;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
            List<StartBlock> blocks = program.getCFG();
            printCFG(blocks);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printCFG(List<StartBlock> blockList) {
        try {
            FileWriter writer = new FileWriter(new File("cfg.gv"));
            StringBuilder output = new StringBuilder();
            Set<CFGBlock> visitedBlocks = new HashSet<CFGBlock>();

            writer.write("digraph G {\n");
            writer.write("size =\"8.5,11\";");

            for (CFGBlock block : blockList) {
                block.getGraphVisFormat(visitedBlocks, output);
            }
            writer.write(output.toString());
            writer.write("}");

            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
