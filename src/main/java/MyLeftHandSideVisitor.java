import ast.interfaces.LeftSide;
import ast.values.Identifier;
import ast.values.LeftIdDot;

public class MyLeftHandSideVisitor extends Java8BaseVisitor<LeftSide> {

    @Override
    public LeftSide visitLeftHandSide(Java8Parser.LeftHandSideContext ctx) {

        if(ctx.arrayAccess() != null) {

        }
        else if (ctx.expressionName() != null) {
            return visitExpressionName(ctx.expressionName());
        }
        else if (ctx.fieldAccess() != null) {

        }

        return super.visitLeftHandSide(ctx);
    }

    @Override
    public LeftSide visitExpressionName(Java8Parser.ExpressionNameContext ctx) {

        String id = ctx.Identifier().toString();
        if(ctx.expressionName() != null) {
            LeftSide left = visitExpressionName(ctx.expressionName());
            return new LeftIdDot(id, left);
        }
        return new Identifier(id);
    }
}