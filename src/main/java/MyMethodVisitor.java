import ast.Block;
import ast.expressions.left.Identifier;
import ast.literal.Literal;
import ast.statements.DeclarationStatement;
import ast.Method;

import java.util.ArrayList;
import java.util.List;

public class MyMethodVisitor extends Java8BaseVisitor<Method> {

    @Override
    public Method visitMethodDeclaration(Java8Parser.MethodDeclarationContext ctx) {
        Block blocks = Driver.blockVisitor.visitBlockStatements(ctx.methodBody().block().blockStatements());
        String name = ctx.methodHeader().methodDeclarator().Identifier().toString();
        List<DeclarationStatement> params = new ArrayList<>();
        if(ctx.methodHeader().methodDeclarator() != null) {
            handleParameters(ctx.methodHeader().methodDeclarator().formalParameterList(), params);
        }
        return new Method(Driver.currentFileName, ctx.start.getLine(), name, params, blocks);
    }

//    private List<DeclarationStatement> gatherDeclarations(Java8Parser.BlockStatementsContext statementsContext) {
//
//        List<DeclarationStatement> declarations = new ArrayList<DeclarationStatement>();
//
//        for(Java8Parser.BlockStatementContext context : statementsContext.blockStatement()) {
//            if (context.localVariableDeclarationStatement() != null) {
//                Java8Parser.LocalVariableDeclarationContext declInst = context.localVariableDeclarationStatement().localVariableDeclaration();
//
//                declarations.addAll(Driver.declarationVisitor.visitLocalVariableDeclaration(declInst));
//            }
//        }
//
//        return declarations;
//    }

    public void handleParameters(Java8Parser.FormalParameterListContext ctx, List<DeclarationStatement> params) {

        if (ctx != null) {
            if (ctx.formalParameters() != null) {
                for (Java8Parser.FormalParameterContext param : ctx.formalParameters().formalParameter()) {
                    handleFormalParameter(param, params);
                }
            }
            if(ctx.lastFormalParameter() != null) {
                handleFormalParameter(ctx.lastFormalParameter().formalParameter(), params);
            }
        }
    }

    private void handleFormalParameter(Java8Parser.FormalParameterContext ctx, List<DeclarationStatement> params) {
        Identifier id = new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.variableDeclaratorId().Identifier().getText());
        DeclarationStatement decl = new DeclarationStatement(Driver.currentFileName, ctx.start.getLine(), id, null);
        params.add(decl);
    }
}
