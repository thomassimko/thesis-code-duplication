import ast.ClassObject;
import ast.Method;
import ast.expressions.*;
import ast.expressions.left.ArrayAccessExpression;
import ast.expressions.left.Identifier;
import ast.expressions.left.LeftIdDot;
import ast.literal.Array;
import ast.literal.Super;
import ast.literal.This;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MyPrimaryVisitor extends Java8BaseVisitor<Expression> {

    @Override
    public Expression visitPrimary(Java8Parser.PrimaryContext ctx) {

        //ctx.

        //'new' primitiveType dimExprs dims?
        //	|	'new' classOrInterfaceType dimExprs dims?
        //	|	'new' primitiveType dims arrayInitializer
        //	|	'new' classOrInterfaceType dims arrayInitializer

        Expression exp = null;


        if(ctx.arrayCreationExpression() != null) {

            if(ctx.arrayCreationExpression().arrayInitializer() != null) {
                exp = handleArrayInitializer(ctx.arrayCreationExpression().arrayInitializer());
            } else if(ctx.arrayCreationExpression().dimExprs() != null) {
                ArrayList<Expression> lengths = new ArrayList<Expression>();

                for(Java8Parser.DimExprContext dim : ctx.arrayCreationExpression().dimExprs().dimExpr()) {
                    lengths.add(Driver.expressionVisitor.visitExpression(dim.expression()));
                }

                exp = new Array(Driver.currentFileName, ctx.start.getLine(), lengths);
            }
            if(exp == null) {
                exp = new Array(Driver.currentFileName, ctx.start.getLine(), null);
            }
        }
        else if(ctx.primaryNoNewArray_lfno_primary() != null) {
            exp = handlePrimaryNoNewArray_lfno_primary(ctx.primaryNoNewArray_lfno_primary());
        }


        if(ctx.primaryNoNewArray_lf_primary() != null) {

            for(Java8Parser.PrimaryNoNewArray_lf_primaryContext left : ctx.primaryNoNewArray_lf_primary()) {
                exp = handlePrimaryNoNewArray_lf_primaryContext(left, exp);
            }
        }

        if(exp == null)
            System.err.println("not covered primary");
        return exp;
    }

    public Expression handleArrayInitializer(Java8Parser.ArrayInitializerContext ctx) {

        ArrayList<Expression> values = new ArrayList<Expression>();

        for(Java8Parser.VariableInitializerContext var : ctx.variableInitializerList().variableInitializer()) {
            if(var.expression() != null) {
                values.add(Driver.expressionVisitor.visitExpression(var.expression()));
            } else {
                values.add(handleArrayInitializer(var.arrayInitializer()));
            }
        }

        return new Array(Driver.currentFileName, ctx.start.getLine(), values);
    }

    public Expression handlePrimaryNoNewArray_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primaryContext ctx) {


//        	:	literal
//                |	typeName ('[' ']')* '.' 'class'
//                |	unannPrimitiveType ('[' ']')* '.' 'class'
//                |	'void' '.' 'class'
//                |	'this'
//                |	typeName '.' 'this'
//                |	'(' expression ')'
//                |	classInstanceCreationExpression_lfno_primary
//                |	fieldAccess_lfno_primary
//                |	arrayAccess_lfno_primary
//                |	methodInvocation_lfno_primary
//                |	methodReference_lfno_primary
        if(ctx.literal() != null) {
            return Driver.literalVisitor.visitLiteral(ctx.literal());
        } else if (ctx.expression() != null) {
            return Driver.expressionVisitor.visitExpression(ctx.expression());
        } else if (ctx.voidDotClass() != null) {
            return new ClassType(Driver.currentFileName, ctx.start.getLine(), "void");
        } else if (ctx.typeDotClass() != null) {
            return handleTypeDotClass(ctx.typeDotClass());
        } else if (ctx.typeDotThis() != null) {
            return handleTypeDotThis(ctx.typeDotThis());
        } else if (ctx.primitiveTypeDotClass() != null) {
            return handlePrimitiveTypeDotClass(ctx.primitiveTypeDotClass());
        } else if (ctx.voidDotClass() != null) {
            return handleVoidDotClass(ctx.voidDotClass());
        } else if (ctx.classInstanceCreationExpression_lfno_primary() != null) {
            return handleClassInstanceCreationExpression_lfno_primary(ctx.classInstanceCreationExpression_lfno_primary());
        } else if (ctx.fieldAccess_lfno_primary() != null) {
            return handleFieldAccess_lfno_primary(ctx.fieldAccess_lfno_primary());
        } else if (ctx.arrayAccess_lfno_primary() != null) {
            return handleArrayAccess_lfno_primary(ctx.arrayAccess_lfno_primary());
        } else if (ctx.methodInvocation_lfno_primary() != null) {
            return handleMethodInvocation_lfno_primary(ctx.methodInvocation_lfno_primary());
        } else if (ctx.methodReference_lfno_primary() != null) {
            return handleMethodReference_lfno_primary(ctx.methodReference_lfno_primary());
        } else if(ctx.getText().equalsIgnoreCase("this")) {
            return new This(Driver.currentFileName, ctx.start.getLine());
        }
        System.out.println("ERROR: handlePrimaryNoNewArray_lfno_primary");
        return null;
    }

    public Expression handleTypeDotClass(Java8Parser.TypeDotClassContext ctx) {
        return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), "class", new Type(Driver.currentFileName, ctx.start.getLine(), ctx.typeName().getText()));
    }

    public Expression handleTypeDotThis(Java8Parser.TypeDotThisContext ctx) {
        return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), "this", new Type(Driver.currentFileName, ctx.start.getLine(), ctx.typeName().getText()));
    }

    public Expression handlePrimitiveTypeDotClass(Java8Parser.PrimitiveTypeDotClassContext ctx) {
        return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), "class", new Type(Driver.currentFileName, ctx.start.getLine(), ctx.unannPrimitiveType().getText()));
    }

    public Expression handleVoidDotClass(Java8Parser.VoidDotClassContext ctx) {
        return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), "class", new Type(Driver.currentFileName, ctx.start.getLine(), "void"));
    }

    public Expression handleClassInstanceCreationExpression_lfno_primary(Java8Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx) {

        ClassObject clss = null;
        Expression exp = null;
        List<Expression> args = new ArrayList<Expression>();
        Identifier className = null;

        if(ctx.Identifier(0) != null) {
            className = new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.Identifier(0).getText());
        }

        if(ctx.expressionName() != null)
            exp = handleExpressionName(ctx.expressionName());

        if(ctx.classBody() != null) {
            clss = Driver.classDeclarationVisitor.visitClassBody(ctx.classBody());
        }
        if(ctx.argumentList() != null) {
            for(Java8Parser.ExpressionContext arg : ctx.argumentList().expression()) {
                args.add(Driver.expressionVisitor.visitExpression(arg));
            }
        }

        return new ClassInstanceExpression(Driver.currentFileName, ctx.start.getLine(), exp, args, clss, className);

    }

    public Expression handleExpressionName(Java8Parser.ExpressionNameContext ctx) {
        if(ctx.expressionName() != null) {
            return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), ctx.Identifier().getText(), handleExpressionName(ctx.expressionName()));
        }
        return new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.Identifier().getText());

    }

    public Expression handleFieldAccess_lfno_primary(Java8Parser.FieldAccess_lfno_primaryContext ctx) {

        int line = ctx.start.getLine();
        String file = Driver.currentFileName;

//        Expression exp = new Super(file, line);
//        if(ctx.typeName() != null) {
//            ctx.typeName().
//        }

        System.err.println("Found fieldAccess_lfno_primary");
        return null;

        //Identifier id = new Identifier(ctx.start.getLine(), ctx.getText());

        //TODO: doesn't deal with super or typeName

        //return id;


    }

    public Expression handleArrayAccess_lfno_primary(Java8Parser.ArrayAccess_lfno_primaryContext ctx) {

        Expression left = null;
        List<Expression> accessor = new ArrayList<Expression>();
        for(Java8Parser.ExpressionContext exp: ctx.expression()) {
            accessor.add(Driver.expressionVisitor.visitExpression(exp));
        }

        if(ctx.expressionName() != null) {
            left = Driver.leftHandSideVisitor.visitExpressionName(ctx.expressionName());
        } else {
            left = handlePrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(ctx.primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary());
        }
        return new ArrayAccessExpression(Driver.currentFileName, ctx.start.getLine(), left, accessor);

    }

    public Expression handlePrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx) {
//        literal
//        |   typeDotClass
//        |   voidDotClass
//        |   typeDotThis
//        |   primitiveTypeDotClass
//        |	'this'
//        |	'(' expression ')'
//        |	classInstanceCreationExpression_lfno_primary
//        |	fieldAccess_lfno_primary
//        |	methodInvocation_lfno_primary
//        |	methodReference_lfno_primary

        if(ctx.literal() != null) {
            return Driver.literalVisitor.visitLiteral(ctx.literal());
        } else if(ctx.typeDotClass() != null) {
            return handleTypeDotClass(ctx.typeDotClass());
        } else if(ctx.voidDotClass() != null) {
            return handleVoidDotClass(ctx.voidDotClass());
        } else if(ctx.typeDotThis() != null) {
            return handleTypeDotThis(ctx.typeDotThis());
        } else if(ctx.primitiveTypeDotClass() != null) {
            return handlePrimitiveTypeDotClass(ctx.primitiveTypeDotClass());
        } else if(ctx.expression() != null) {
            return Driver.expressionVisitor.visitExpression(ctx.expression());
        } else if(ctx.classInstanceCreationExpression_lfno_primary() != null) {
            return handleClassInstanceCreationExpression_lfno_primary(ctx.classInstanceCreationExpression_lfno_primary());
        } else if(ctx.fieldAccess_lfno_primary() != null) {
            return handleFieldAccess_lfno_primary(ctx.fieldAccess_lfno_primary());
        } else if(ctx.methodInvocation_lfno_primary() != null) {
            return handleMethodInvocation_lfno_primary(ctx.methodInvocation_lfno_primary());
        } else if(ctx.methodReference_lfno_primary() != null) {
            return handleMethodReference_lfno_primary(ctx.methodReference_lfno_primary());
        }
        System.err.println("primary visitor handlePrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary");

        return null;
    }

    public Expression handleMethodInvocation_lfno_primary(Java8Parser.MethodInvocation_lfno_primaryContext ctx) {

        List<Expression> args = new ArrayList<Expression>();
        Identifier methodName = null;
        Expression leftSide = null;


        if(ctx.argumentList() != null) {
            for(Java8Parser.ExpressionContext arg: ctx.argumentList().expression()) {
                args.add(Driver.expressionVisitor.visitExpression(arg));
            }
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

    public Expression handleMethodReference_lfno_primary(Java8Parser.MethodReference_lfno_primaryContext ctx) {
        System.err.println("Found methodReference_lfno_primary");
        return null;
    }

    private Expression handlePrimaryNoNewArray_lf_primaryContext(Java8Parser.PrimaryNoNewArray_lf_primaryContext ctx, Expression in) {
        if(ctx.arrayAccess_lf_primary() != null) {
            System.err.println("ctx.arrayAccess_lf_primary()");
        } else if(ctx.classInstanceCreationExpression_lf_primary() != null) {
            System.err.println("ctx.classInstanceCreationExpression_lf_primary()");
        } else if(ctx.fieldAccess_lf_primary() != null) {
            String id = ctx.fieldAccess_lf_primary().Identifier().getText();
            return new LeftIdDot(Driver.currentFileName, ctx.start.getLine(), id, in);
        } else if(ctx.methodInvocation_lf_primary() != null) {
            return this.handleMethodInvocation_lf_primary(ctx.methodInvocation_lf_primary());
        } else if(ctx.methodReference_lf_primary() != null) {
            System.err.println("ctx.methodReference_lf_primary()");
        }
        System.err.println("No primary found for PrimaryNoNewArray_lf_primaryContext");
        return null;
    }

    public Expression handleMethodInvocation_lf_primary(Java8Parser.MethodInvocation_lf_primaryContext ctx) {
        List<Expression> args = new ArrayList<Expression>();
        Identifier methodName = null;
        Expression leftSide = null;


        if(ctx.argumentList() != null) {
            for(Java8Parser.ExpressionContext arg: ctx.argumentList().expression()) {
                args.add(Driver.expressionVisitor.visitExpression(arg));
            }
        }
        if(ctx.Identifier() != null) {
            methodName = new Identifier(Driver.currentFileName, ctx.start.getLine(), ctx.Identifier().getText());
        }

        return new CallExpression(Driver.currentFileName, ctx.start.getLine(), methodName, args, leftSide);
    }


}
