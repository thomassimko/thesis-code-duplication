import ast.Block;
import ast.statements.DeclarationStatement;
import ast.Method;

import java.util.ArrayList;
import java.util.List;

public class MyMethodVisitor extends Java8BaseVisitor<Method> {

    @Override
    public Method visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        Block blocks = Driver.blockVisitor.visitBlockStatements(ctx.methodBody().block().blockStatements());
        String name = ctx.methodHeader().methodDeclarator().Identifier().toString();
        return new Method(Driver.currentFileName, ctx.start.getLine(), name, blocks);
    }

    private List<DeclarationStatement> gatherDeclarations(Java8Parser.BlockStatementsContext statementsContext) {

        List<DeclarationStatement> declarations = new ArrayList<DeclarationStatement>();

        for(Java8Parser.BlockStatementContext context : statementsContext.blockStatement()) {
            if (context.localVariableDeclarationStatement() != null) {
                Java8Parser.LocalVariableDeclarationContext declInst = context.localVariableDeclarationStatement().localVariableDeclaration();

                declarations.addAll(Driver.declarationVisitor.visitLocalVariableDeclaration(declInst));
            }
        }

        return declarations;
    }
}
