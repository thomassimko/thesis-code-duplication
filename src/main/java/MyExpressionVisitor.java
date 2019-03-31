import ast.expressions.*;
import ast.expressions.Expression;
import ast.expressions.left.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MyExpressionVisitor extends Java8BaseVisitor<Expression> {

    @Override
    public Expression visitExpression(Java8Parser.ExpressionContext ctx) {

        if (ctx.assignmentExpression() != null) {

            return handleAssignmentExpression(ctx.assignmentExpression());
        }
        else if (ctx.lambdaExpression() != null) {

            System.out.println("lambda: " + ctx.lambdaExpression().toString());
            //TODO: Lambda exp
        }
        System.out.println("Unfound expression: " + ctx.getText());
        return super.visitExpression(ctx);
    }

    @Override
    public Expression visitStatementExpression(Java8Parser.StatementExpressionContext ctx) {

        if(ctx.assignment() != null) {
            return handleAssignment(ctx.assignment());
        } else if (ctx.classInstanceCreationExpression() != null) {

        } else if (ctx.methodInvocation() != null) {
            return handleMethodInvocation(ctx.methodInvocation());
        } else if (ctx.postDecrementExpression() != null) {
            return handlePostFixExpression(ctx.postDecrementExpression().postfixExpression(), "--");
        } else if (ctx.postIncrementExpression() != null) {
            return handlePostFixExpression(ctx.postIncrementExpression().postfixExpression(), "++");
        } else if (ctx.preDecrementExpression() != null) {
            return new PreUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "--", handleUnaryExpression(ctx.preDecrementExpression().unaryExpression()));
        } else if (ctx.preIncrementExpression() != null) {
            return new PreUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "++", handleUnaryExpression(ctx.preIncrementExpression().unaryExpression()));
        }
        System.err.println("Statement Expression not found: " + ctx.getText());
        return super.visitStatementExpression(ctx);
    }

    private Expression handleMethodInvocation(Java8Parser.MethodInvocationContext ctx) {

        List<Expression> args = new ArrayList<Expression>();
        Identifier methodName = null;
        Expression leftSide = null;


        if(ctx.argumentList() != null) {
            for(Java8Parser.ExpressionContext arg: ctx.argumentList().expression()) {
                args.add(visitExpression(arg));
            }
        }

        if(ctx.primary() != null) {
            System.err.println("ctx primary in method call: " + ctx.getText());
        }
        if (ctx.typeName() != null) {
            leftSide = Driver.leftHandSideVisitor.visitTypeName(ctx.typeName());
        } else if(ctx.expressionName() != null) {
            leftSide = Driver.leftHandSideVisitor.visitExpressionName(ctx.expressionName());
        }

        if(ctx.methodName() != null) {
            methodName = new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.methodName().Identifier().getText());
        } else if(ctx.Identifier() != null) {
            methodName = new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.Identifier().getText());
        }

        return new CallExpression(Driver.currentFileName, ctx.start.getLine(), methodName, args, leftSide);
    }


    private Expression handleAssignmentExpression(Java8Parser.AssignmentExpressionContext ctx) {
        if(ctx.assignment() != null) {
            return handleAssignment(ctx.assignment());
        }
        else if (ctx.conditionalExpression() != null) {
            return handleConditionalExpression(ctx.conditionalExpression());

        }
        System.out.println("Unfound assignment expression: " + ctx.getText());
        return null;
    }

    private Expression handleAssignment(Java8Parser.AssignmentContext ctx) {
        Expression exp = visitExpression(ctx.expression());
        String op = ctx.assignmentOperator().getText();
        Expression left = Driver.leftHandSideVisitor.visitLeftHandSide(ctx.leftHandSide());
        return new AssignmentExpression(Driver.currentFileName, ctx.start.getLine(), left, op, exp);
    }

    private Expression handleConditionalExpression(Java8Parser.ConditionalExpressionContext ctx) {
        if (ctx.expression() != null) {
            Expression falseExp = handleConditionalExpression(ctx.conditionalExpression());
            Expression trueExp = visitExpression(ctx.expression());
            Expression cond = handleConditionalOrExpression(ctx.conditionalOrExpression());
            return new TernaryExpression(Driver.currentFileName, ctx.start.getLine(), cond, trueExp, falseExp);
        }
        return handleConditionalOrExpression(ctx.conditionalOrExpression());
    }

    private Expression handleConditionalOrExpression(Java8Parser.ConditionalOrExpressionContext ctx) {
        if(ctx.conditionalOrExpression() != null) {
            Expression left = handleConditionalOrExpression(ctx.conditionalOrExpression());
            Expression right = handleConditionalAndExpression(ctx.conditionalAndExpression());
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), "||", left, right);
        }
        return handleConditionalAndExpression(ctx.conditionalAndExpression());
    }

    private Expression handleConditionalAndExpression(Java8Parser.ConditionalAndExpressionContext ctx) {
        if(ctx.conditionalAndExpression() != null) {
            Expression left = handleConditionalAndExpression(ctx.conditionalAndExpression());
            Expression right = handleInclusiveOrExpression(ctx.inclusiveOrExpression());
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), "&&", left, right);
        }
        return handleInclusiveOrExpression(ctx.inclusiveOrExpression());
    }

    private Expression handleInclusiveOrExpression(Java8Parser.InclusiveOrExpressionContext ctx) {
        if(ctx.inclusiveOrExpression() != null) {
            Expression left = handleInclusiveOrExpression(ctx.inclusiveOrExpression());
            Expression right = handleExclusiveOrExpression(ctx.exclusiveOrExpression());
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), "|", left, right);
        }
        return handleExclusiveOrExpression(ctx.exclusiveOrExpression());
    }

    private Expression handleExclusiveOrExpression(Java8Parser.ExclusiveOrExpressionContext ctx) {
        if(ctx.exclusiveOrExpression() != null) {
            Expression left = handleExclusiveOrExpression(ctx.exclusiveOrExpression());
            Expression right = handleAndExpression(ctx.andExpression());
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), "^", left, right);
        }
        return handleAndExpression(ctx.andExpression());
    }

    private Expression handleAndExpression(Java8Parser.AndExpressionContext ctx) {
        if(ctx.andExpression() != null) {
            Expression left = handleAndExpression(ctx.andExpression());
            Expression right = handleEqualityExpression(ctx.equalityExpression());
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), "&", left, right);
        }
        return handleEqualityExpression(ctx.equalityExpression());
    }

    private Expression handleEqualityExpression(Java8Parser.EqualityExpressionContext ctx) {
        if(ctx.equalityExpression() != null) {
            Expression left = handleEqualityExpression(ctx.equalityExpression());
            Expression right = handleRelationalExpression(ctx.relationalExpression());
            String op = ctx.getText().contains("==") ? "==" : "!=";
            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), op, left, right);
        }
        return handleRelationalExpression(ctx.relationalExpression());
    }

    private Expression handleRelationalExpression(Java8Parser.RelationalExpressionContext ctx) {
        if(ctx.relationalExpression() != null) {
            Expression left = handleRelationalExpression(ctx.relationalExpression());
            Expression right = handleShiftExpression(ctx.shiftExpression());


            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), left, right);
        }
        return handleShiftExpression(ctx.shiftExpression());
    }

    private Expression handleShiftExpression(Java8Parser.ShiftExpressionContext ctx) {
        if(ctx.shiftExpression() != null) {
            Expression left = handleShiftExpression(ctx.shiftExpression());
            Expression right = handleAdditiveExpression(ctx.additiveExpression());

            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), left, right);
        }
        return handleAdditiveExpression(ctx.additiveExpression());
    }

    private Expression handleAdditiveExpression(Java8Parser.AdditiveExpressionContext ctx) {
        if(ctx.additiveExpression() != null) {
            Expression left = handleAdditiveExpression(ctx.additiveExpression());
            Expression right = handleMultiplicativeExpression(ctx.multiplicativeExpression());

            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), left, right);
        }
        return handleMultiplicativeExpression(ctx.multiplicativeExpression());
    }

    private Expression handleMultiplicativeExpression(Java8Parser.MultiplicativeExpressionContext ctx) {
        if(ctx.multiplicativeExpression() != null) {
            Expression left = handleMultiplicativeExpression(ctx.multiplicativeExpression());
            Expression right = handleUnaryExpression(ctx.unaryExpression());

            return new BinaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), left, right);
        }
        return handleUnaryExpression(ctx.unaryExpression());
    }

    private Expression handleUnaryExpression(Java8Parser.UnaryExpressionContext ctx) {
        if(ctx.preIncrementExpression() != null) {
            Expression exp = handleUnaryExpression(ctx.unaryExpression());
            return new PreUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "++", exp);

        } else if(ctx.preDecrementExpression() != null) {
            Expression exp = handleUnaryExpression(ctx.unaryExpression());
            return new PreUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "--", exp);

        } else if(ctx.unaryExpressionNotPlusMinus() != null) {
            return handleUnaryExpressionNotPlusMinus(ctx.unaryExpressionNotPlusMinus());
        }
        Expression exp = handleUnaryExpression(ctx.unaryExpression());
        return new UnaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), exp);
    }

    private Expression handleUnaryExpressionNotPlusMinus(Java8Parser.UnaryExpressionNotPlusMinusContext ctx) {
        if(ctx.unaryExpression() != null) {
            return new UnaryExpression(Driver.currentFileName, ctx.start.getLine(), ctx.op.getText(), handleUnaryExpression(ctx.unaryExpression()));
        } else if (ctx.castExpression() != null) {
            return handleCastExpression(ctx.castExpression());
        } else {
            return handlePostFixExpression(ctx.postfixExpression(), null);
        }
    }

    private Expression handleCastExpression(Java8Parser.CastExpressionContext ctx) {
        if(ctx.unaryExpression() != null) {
            return new CastExpression(Driver.currentFileName, ctx.start.getLine(), handleUnaryExpression(ctx.unaryExpression()));
        } else if (ctx.unaryExpressionNotPlusMinus() != null) {
            return new CastExpression(Driver.currentFileName, ctx.start.getLine(), handleUnaryExpressionNotPlusMinus(ctx.unaryExpressionNotPlusMinus()));
        } else {
            //TODO: lambda exp
            ctx.lambdaExpression();
            return null;
        }
    }

    private Expression handlePostFixExpression(Java8Parser.PostfixExpressionContext ctx, String op) {
        Expression exp = null;
        if(ctx.expressionName() != null) {
            exp = Driver.leftHandSideVisitor.visitExpressionName(ctx.expressionName());
        } else if (ctx.primary() != null) {
            exp = Driver.primaryVisitor.visitPrimary(ctx.primary());
        }
        if(op != null)
            exp = new PostUnaryExpression(Driver.currentFileName, ctx.start.getLine(), op, exp);
        for (Java8Parser.PostDecrementExpression_lf_postfixExpressionContext dec : ctx.postDecrementExpression_lf_postfixExpression()) {
            exp = new PostUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "--", exp);
        }
        for (Java8Parser.PostIncrementExpression_lf_postfixExpressionContext inc : ctx.postIncrementExpression_lf_postfixExpression()) {
            exp = new PostUnaryExpression(Driver.currentFileName, ctx.start.getLine(), "++", exp);
        }
        return exp;
    }




}
