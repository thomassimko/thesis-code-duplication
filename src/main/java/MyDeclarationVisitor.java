import ast.Declaration;
import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class MyDeclarationVisitor extends Java8BaseVisitor<List<Declaration>> {

    @Override
    public List<Declaration> visitLocalVariableDeclaration(Java8Parser.LocalVariableDeclarationContext ctx) {
        List<Declaration> declarations = new ArrayList<Declaration>();

        for (Java8Parser.VariableDeclaratorContext decl : ctx.variableDeclaratorList().variableDeclarator()) {
            Expression exp = null;
            String varName = decl.variableDeclaratorId().Identifier().getSymbol().getText();

            if (decl.variableInitializer() != null) {
                exp = Driver.expressionVisitor.visitExpression(decl.variableInitializer().expression());
            }
            declarations.add(new Declaration(varName, exp));
        }

        return declarations;
    }
}
