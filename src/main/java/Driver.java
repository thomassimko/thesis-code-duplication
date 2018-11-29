import ast.Program;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


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

            program.printProgram();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
