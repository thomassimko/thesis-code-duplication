import ast.Block;
import ast.Declaration;
import ast.Method;

import java.util.ArrayList;
import java.util.List;

public class MyMethodVisitor extends Java8BaseVisitor<Method> {

    @Override
    public Method visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        Block blocks = Driver.blockVisitor.visitBlockStatements(ctx.methodBody().block().blockStatements());
        return new Method(blocks);
    }

    private List<Declaration> gatherDeclarations(Java8Parser.BlockStatementsContext statementsContext) {

        List<Declaration> declarations = new ArrayList<Declaration>();

        for(Java8Parser.BlockStatementContext context : statementsContext.blockStatement()) {
            if (context.localVariableDeclarationStatement() != null) {
                Java8Parser.LocalVariableDeclarationContext declInst = context.localVariableDeclarationStatement().localVariableDeclaration();

                declarations.addAll(Driver.declarationVisitor.visitLocalVariableDeclaration(declInst));
            }
        }

        return declarations;
    }
}
