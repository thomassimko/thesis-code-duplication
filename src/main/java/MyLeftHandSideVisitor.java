import ast.expressions.left.ArrayAccessExpression;
import ast.expressions.Expression;
import ast.expressions.left.Identifier;
import ast.expressions.left.LeftIdDot;

import java.util.ArrayList;
import java.util.List;

public class MyLeftHandSideVisitor extends Java8BaseVisitor<Expression> {

    @Override
    public Expression visitLeftHandSide(Java8Parser.LeftHandSideContext ctx) {

        if(ctx.arrayAccess() != null) {

            if(ctx.arrayAccess().expressionName() != null) {
                Expression left = Driver.leftHandSideVisitor.visitExpressionName(ctx.arrayAccess().expressionName());

                List<Expression> accessors = new ArrayList<Expression>();
                for(Java8Parser.ExpressionContext exp: ctx.arrayAccess().expression()) {
                    accessors.add(Driver.expressionVisitor.visitExpression(exp));
                }
                return new ArrayAccessExpression(ctx.start.getLine(), left, accessors);
            }
            else if(ctx.arrayAccess().primaryNoNewArray_lfno_arrayAccess() != null) {
                System.err.println("left sidevisitor: lfno_array");
                return null;
            }

            if( ctx.arrayAccess().primaryNoNewArray_lf_arrayAccess(0) != null) {
                System.err.println("left sidevisitor: lf_array");
                return null;
            }
        }
        else if (ctx.expressionName() != null) {
            return visitExpressionName(ctx.expressionName());
        }
        else if (ctx.fieldAccess() != null) {
            System.err.println("field access not found leftsidevisitor");
        }

        return super.visitLeftHandSide(ctx);
    }

    @Override
    public Expression visitExpressionName(Java8Parser.ExpressionNameContext ctx) {

        String id = ctx.Identifier().toString();
        if(ctx.expressionName() != null) {
            Expression left = visitExpressionName(ctx.expressionName());
            return new LeftIdDot(ctx.start.getLine(), id, left);
        }
        return new Identifier(ctx.start.getLine(), id);
    }

    @Override
    public Expression visitTypeName(Java8Parser.TypeNameContext ctx) {

        String id = ctx.Identifier().getText();

        if(ctx.packageOrTypeName() != null) {
            Expression exp = visitPackageOrTypeName(ctx.packageOrTypeName());
            return new LeftIdDot(ctx.start.getLine(), id, exp);
        }
        return new Identifier(ctx.start.getLine(), id);
    }

    @Override
    public Expression visitPackageOrTypeName(Java8Parser.PackageOrTypeNameContext ctx) {

        String id = ctx.Identifier().getText();

        if(ctx.packageOrTypeName() != null) {
            Expression exp = visitPackageOrTypeName(ctx.packageOrTypeName());
            return new LeftIdDot(ctx.start.getLine(), id, exp);
        }

        return new Identifier(ctx.start.getLine(), id);
    }

}