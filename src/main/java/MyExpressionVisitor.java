import ast.expressions.*;
import ast.interfaces.Expression;
import ast.interfaces.LeftSide;

public class MyExpressionVisitor extends Java8BaseVisitor<Expression> {

    @Override
    public Expression visitExpression(Java8Parser.ExpressionContext ctx) {

        if (ctx.assignmentExpression() != null) {
            return handleAssignmentExpression(ctx.assignmentExpression());
        }
        else if (ctx.lambdaExpression() != null) {

        }
        System.out.println("Unfound expression: " + ctx.getText());
        return super.visitExpression(ctx);
    }

    @Override
    public Expression visitStatementExpression(Java8Parser.StatementExpressionContext ctx) {
        return super.visitStatementExpression(ctx);
    }


    private Expression handleAssignmentExpression(Java8Parser.AssignmentExpressionContext ctx) {
        if(ctx.assignment() != null) {
            Expression exp = visitExpression(ctx.assignment().expression());
            String op = ctx.assignment().assignmentOperator().getText();
            LeftSide left = Driver.leftHandSideVisitor.visitLeftHandSide(ctx.assignment().leftHandSide());

            return new AssignmentExpression(left, op, exp);
        }
        else if (ctx.conditionalExpression() != null) {

            handleConditionalExpression(ctx.conditionalExpression());

        }
        System.out.println("Unfound assignment expression: " + ctx.getText());
        return null;
    }

    private Expression handleConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if (ctx.expression() != null) {
            Expression falseExp = handleConditionalExpression(ctx.conditionalExpression());
            Expression trueExp = visitExpression(ctx.expression());
            Expression cond = handleConditionalOrExpression(ctx.conditionalOrExpression());
            return new TernaryExpression(cond, trueExp, falseExp);
        }
        return handleConditionalOrExpression(ctx.conditionalOrExpression());
    }

    private Expression handleConditionalOrExpression(Java8Parser.ConditionalOrExpressionContext ctx) {
        if(ctx.conditionalOrExpression() != null) {
            Expression left = handleConditionalOrExpression(ctx.conditionalOrExpression());
            Expression right = handleConditionalAndExpression(ctx.conditionalAndExpression());
            return new BinaryExpression("||", left, right);
        }
        return handleConditionalAndExpression(ctx.conditionalAndExpression());
    }

    private Expression handleConditionalAndExpression(Java8Parser.ConditionalAndExpressionContext ctx) {
        if(ctx.conditionalAndExpression() != null) {
            Expression left = handleConditionalAndExpression(ctx.conditionalAndExpression());
            Expression right = handleInclusiveOrExpression(ctx.inclusiveOrExpression());
            return new BinaryExpression("&&", left, right);
        }
        return handleInclusiveOrExpression(ctx.inclusiveOrExpression());
    }

    private Expression handleInclusiveOrExpression(Java8Parser.InclusiveOrExpressionContext ctx) {
        if(ctx.inclusiveOrExpression() != null) {
            Expression left = handleInclusiveOrExpression(ctx.inclusiveOrExpression());
            Expression right = handleExclusiveOrExpression(ctx.exclusiveOrExpression());
            return new BinaryExpression("|", left, right);
        }
        return handleExclusiveOrExpression(ctx.exclusiveOrExpression());
    }

    private Expression handleExclusiveOrExpression(Java8Parser.ExclusiveOrExpressionContext ctx) {
        if(ctx.exclusiveOrExpression() != null) {
            Expression left = handleExclusiveOrExpression(ctx.exclusiveOrExpression());
            Expression right = handleAndExpression(ctx.andExpression());
            return new BinaryExpression("^", left, right);
        }
        return handleAndExpression(ctx.andExpression());
    }

    private Expression handleAndExpression(Java8Parser.AndExpressionContext ctx) {
        if(ctx.andExpression() != null) {
            Expression left = handleAndExpression(ctx.andExpression());
            Expression right = handleEqualityExpression(ctx.equalityExpression());
            return new BinaryExpression("&", left, right);
        }
        return handleEqualityExpression(ctx.equalityExpression());
    }

    private Expression handleEqualityExpression(Java8Parser.EqualityExpressionContext ctx) {
        if(ctx.equalityExpression() != null) {
            Expression left = handleEqualityExpression(ctx.equalityExpression());
            Expression right = handleRelationalExpression(ctx.relationalExpression());
            String op = ctx.getText().contains("==") ? "==" : "!=";
            return new BinaryExpression(op, left, right);
        }
        return handleRelationalExpression(ctx.relationalExpression());
    }

    private Expression handleRelationalExpression(Java8Parser.RelationalExpressionContext ctx) {
        if(ctx.relationalExpression() != null) {
            Expression left = handleRelationalExpression(ctx.relationalExpression());
            Expression right = handleShiftExpression(ctx.shiftExpression());


            return new BinaryExpression(ctx.op.getText(), left, right);
        }
        return handleShiftExpression(ctx.shiftExpression());
    }

    private Expression handleShiftExpression(Java8Parser.ShiftExpressionContext ctx) {
        if(ctx.shiftExpression() != null) {
            Expression left = handleShiftExpression(ctx.shiftExpression());
            Expression right = handleAdditiveExpression(ctx.additiveExpression());

            return new BinaryExpression(ctx.op.getText(), left, right);
        }
        return handleAdditiveExpression(ctx.additiveExpression());
    }

    private Expression handleAdditiveExpression(Java8Parser.AdditiveExpressionContext ctx) {
        if(ctx.additiveExpression() != null) {
            Expression left = handleAdditiveExpression(ctx.additiveExpression());
            Expression right = handleMultiplicativeExpression(ctx.multiplicativeExpression());

            return new BinaryExpression(ctx.op.getText(), left, right);
        }
        return handleMultiplicativeExpression(ctx.multiplicativeExpression());
    }

    private Expression handleMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext ctx) {
        if(ctx.multiplicativeExpression() != null) {
            Expression left = handleMultiplicativeExpression(ctx.multiplicativeExpression());
            Expression right = handleUnaryExpression(ctx.unaryExpression());

            return new BinaryExpression(ctx.op.getText(), left, right);
        }
        return handleUnaryExpression(ctx.unaryExpression());
    }

    private Expression handleUnaryExpression(Java8Parser.UnaryExpressionContext ctx) {
        if(ctx.preIncrementExpression() != null) {
            Expression exp = handleUnaryExpression(ctx.unaryExpression());
            return new PreUnaryExpression("++", exp);

        } else if(ctx.preDecrementExpression() != null) {
            Expression exp = handleUnaryExpression(ctx.unaryExpression());
            return new PreUnaryExpression("--", exp);

        } else if(ctx.unaryExpressionNotPlusMinus() != null) {

        }
        System.out.println(ctx.getText());
        Expression exp = handleUnaryExpression(ctx.unaryExpression());
        return new UnaryExpression(ctx.op.getText(), exp);
    }




}
