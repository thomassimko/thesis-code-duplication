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

            if(decl.variableInitializer() != null)
                System.err.println(decl.variableInitializer().getText());
            AssignmentExpression assgn = null;
            String varName = decl.variableDeclaratorId().Identifier().getSymbol().getText();
            Identifier id = new Identifier(ctx.start.getLine(), varName);

            if (decl.variableInitializer() != null) {
                Expression exp = Driver.expressionVisitor.visitExpression(decl.variableInitializer().expression());
                assgn = new AssignmentExpression(ctx.start.getLine(), id, "=", exp);
            }
            declarations.add(new DeclarationStatement(decl.start.getLine(), varName, assgn));
        }

        return declarations;
    }
}
