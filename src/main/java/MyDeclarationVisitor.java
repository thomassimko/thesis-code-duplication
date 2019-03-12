import ast.literal.*;
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
            Expression exp;
            String varName = decl.variableDeclaratorId().Identifier().getSymbol().getText();
            Identifier id = new Identifier(Driver.currentFileName, ctx.start.getLine(), varName);

            if (decl.variableInitializer() != null) {
                exp = Driver.expressionVisitor.visitExpression(decl.variableInitializer().expression());
            } else {
                exp = getDefaultValueFromType(ctx.unannType());
            }
            AssignmentExpression assgn = new AssignmentExpression(Driver.currentFileName, ctx.start.getLine(), id, "=", exp);
            declarations.add(new DeclarationStatement(Driver.currentFileName, decl.start.getLine(), id, assgn));
        }

        return declarations;
    }

    @Override
    public List<DeclarationStatement> visitFieldDeclaration(Java8Parser.FieldDeclarationContext ctx) {

        Literal defaultExp = getDefaultValueFromType(ctx.unannType());

        List<DeclarationStatement> declarations = new ArrayList<DeclarationStatement>();

        for(Java8Parser.VariableDeclaratorContext varDecl : ctx.variableDeclaratorList().variableDeclarator()) {

            Identifier id = new Identifier(Driver.currentFileName, ctx.start.getLine(), varDecl.variableDeclaratorId().Identifier().toString());
            Expression exp = null;

            if(varDecl.variableInitializer() != null) {
                if(varDecl.variableInitializer().expression() != null) {
                    exp = Driver.expressionVisitor.visitExpression(varDecl.variableInitializer().expression());
                } else if(varDecl.variableInitializer().arrayInitializer() != null) {
                    exp = Driver.primaryVisitor.handleArrayInitializer(varDecl.variableInitializer().arrayInitializer());
                }
            } else {
                exp = defaultExp;
            }
            AssignmentExpression asgn = new AssignmentExpression(Driver.currentFileName, ctx.start.getLine(), id, "=", exp);
            DeclarationStatement decl = new DeclarationStatement(Driver.currentFileName, ctx.start.getLine(), id, asgn);
            declarations.add(decl);

        }
        return declarations;
    }

    private Literal getDefaultValueFromType(Java8Parser.UnannTypeContext ctx) {
        if (ctx.unannReferenceType() != null ){
            return new NullLiteral(Driver.currentFileName, ctx.start.getLine());
        }
        String type = ctx.unannPrimitiveType().getText();

        switch(type) {
            case "boolean":
                return new BooleanLiteral(Driver.currentFileName, ctx.start.getLine(), false);
            case "byte":
            case "int":
            case "short":
            case "long":
                return new IntLiteral(Driver.currentFileName, ctx.start.getLine(), 0);
            case "float":
            case "double":
                return new FloatLiteral(Driver.currentFileName, ctx.start.getLine(), 0);
            case "char":
                return new CharacterLiteral(Driver.currentFileName, ctx.start.getLine(), '\u0000');
        }
        return null;
    }
}
