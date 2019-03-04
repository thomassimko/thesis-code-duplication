import ast.statements.DeclarationStatement;
import ast.expressions.AssignmentExpression;
import ast.expressions.Expression;
import ast.expressions.left.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MyDeclarationVisitor extends Java8BaseVisitor<List<DeclarationStatement>> {

    @Override
    public List<DeclarationStatement> visitLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
        List<DeclarationStatement> declarations = new ArrayList<DeclarationStatement>();

        for (Java8Parser.VariableDeclaratorContext decl : ctx.variableDeclaratorList().variableDeclarator()) {

            AssignmentExpression assgn = null;
            String varName = decl.variableDeclaratorId().Identifier().getSymbol().getText();
            Identifier id = new Identifier(Driver.currentFileName, ctx.start.getLine(), varName);

            if (decl.variableInitializer() != null) {
                Expression exp = Driver.expressionVisitor.visitExpression(decl.variableInitializer().expression());
                assgn = new AssignmentExpression(Driver.currentFileName, ctx.start.getLine(), id, "=", exp);
            }
            declarations.add(new DeclarationStatement(Driver.currentFileName, decl.start.getLine(), id, assgn));
        }

        return declarations;
    }

    @Override
    public List<DeclarationStatement> visitVariableDeclaratorList(Java8Parser.VariableDeclaratorListContext ctx) {
        List<DeclarationStatement> declarations = new ArrayList<DeclarationStatement>();

        for(Java8Parser.VariableDeclaratorContext varDecl : ctx.variableDeclarator()) {

            Identifier id = new Identifier(Driver.currentFileName, ctx.start.getLine(), varDecl.variableDeclaratorId().Identifier().toString());
            Expression exp = null;

            if(varDecl.variableInitializer() != null) {
                if(varDecl.variableInitializer().expression() != null) {
                    exp = Driver.expressionVisitor.visitExpression(varDecl.variableInitializer().expression());
                } else if(varDecl.variableInitializer().arrayInitializer() != null) {
                    exp = Driver.primaryVisitor.handleArrayInitializer(varDecl.variableInitializer().arrayInitializer());
                }
            }

            if(exp != null) {
                AssignmentExpression asgn = new AssignmentExpression(Driver.currentFileName, ctx.start.getLine(), id, "=", exp);
                DeclarationStatement decl = new DeclarationStatement(Driver.currentFileName, ctx.start.getLine(), id, asgn);
                declarations.add(decl);
            }


        }
        return declarations;
    }
}
