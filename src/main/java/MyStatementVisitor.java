import ast.*;
import ast.expressions.AssignmentExpression;
import ast.expressions.Expression;
import ast.statements.Statement;
import ast.statements.*;
import ast.expressions.left.Identifier;

import java.util.ArrayList;
import java.util.List;

public class MyStatementVisitor extends Java8BaseVisitor<Statement> {

    @Override
    public Statement visitStatement(Java8Parser.StatementContext ctx) {

        //If then
        if(ctx.ifThenStatement() != null) {
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.ifThenStatement().expression());
            Statement stmt = visitStatement(ctx.ifThenStatement().statement());
            return new ConditionalStatement(ctx.start.getLine(), exp, stmt, null);
        }
        //If then else
        else if (ctx.ifThenElseStatement() != null) {
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.ifThenElseStatement().expression());
            Statement trueStmt = visitStatement(ctx.ifThenElseStatement().statement().get(0));
            Statement falseStmt = visitStatement(ctx.ifThenElseStatement().statement().get(1));
            return new ConditionalStatement(ctx.start.getLine(), exp, trueStmt, falseStmt);
        }
        //Labeled statement
        else if (ctx.labeledStatement() != null) {
            Statement stmt = visitStatement(ctx.labeledStatement().statement());
            return new LabeledStatement(ctx.start.getLine(), ctx.labeledStatement().Identifier().getSymbol().getText(), stmt);
        }
        //while
        else if (ctx.whileStatement() != null) {
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.whileStatement().expression());
            Statement stmt = visitStatement(ctx.whileStatement().statement());
            return new WhileStatement(ctx.start.getLine(), exp, stmt);
        }
        //for
        else if (ctx.forStatement() != null) {
            return gatherForStatement(ctx.forStatement());
        }
        else if (ctx.assertStatement() != null) {
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.assertStatement().expression(0));
            Expression detail = null;
            if(ctx.assertStatement().expression(1) != null) {
                detail = Driver.expressionVisitor.visitExpression(ctx.assertStatement().expression(1));
            }
            return new AssertStatement(ctx.start.getLine(), exp, detail);
        }
        else if (ctx.block() != null) {
            return Driver.blockVisitor.visitBlockStatements(ctx.block().blockStatements());
        }
        else if (ctx.breakStatement() != null) {
            if(ctx.breakStatement().Identifier() != null) {
                return new BreakStatement(ctx.start.getLine(), ctx.breakStatement().Identifier().toString());
            }
            return new BreakStatement(ctx.start.getLine());
        }
        else if (ctx.continueStatement() != null) {

            if(ctx.continueStatement().Identifier() != null) {
                return new ContinueStatement(ctx.start.getLine(), ctx.continueStatement().Identifier().toString());
            }
            return new ContinueStatement(ctx.start.getLine());
        }
        else if (ctx.doStatement() != null) {
            Statement stmt = visitStatement(ctx.doStatement().statement());
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.doStatement().expression());
            return new DoStatement(ctx.start.getLine(), stmt, exp);
        }
        else if (ctx.emptyStatement() != null) {
            return null;
            //do nothing
        }
        else if (ctx.expressionStatement() != null) {
            Expression exp = Driver.expressionVisitor.visitStatementExpression(ctx.expressionStatement().statementExpression());
            return new ExpressionStatement(ctx.start.getLine(), exp);
        }
        else if (ctx.returnStatement() != null) {
            return new ReturnStatement(ctx.start.getLine(), Driver.expressionVisitor.visitExpression(ctx.returnStatement().expression()));
        }
        else if (ctx.switchStatement() != null) {
            return Driver.switchStatementVisitor.visitSwitchStatement(ctx.switchStatement());
        }
        else if (ctx.synchronizedStatement() != null) {

            Block block = Driver.blockVisitor.visitBlockStatements(ctx.synchronizedStatement().block().blockStatements());
            Expression exp = Driver.expressionVisitor.visitExpression(ctx.synchronizedStatement().expression());
            return new SynchronizedStatement(ctx.start.getLine(), block, exp);

        }
        else if (ctx.throwStatement() != null) {
            return new ThrowStatement(ctx.start.getLine(), Driver.expressionVisitor.visitExpression(ctx.throwStatement().expression()));
        }
        else if (ctx.tryStatement() != null) {
            return handleTryStatement(ctx.tryStatement());
        }
        System.out.println("Unfound Statement: " + ctx.getText());
        return super.visitStatement(ctx);
    }

    private Statement gatherForStatement(Java8Parser.ForStatementContext forStmt) {

        if(forStmt.basicForStatement() != null) {
            //traditional for

            DeclarationStatement declaration = null;
            List<Statement> initStatements = new ArrayList<Statement>();
            Expression exp = null;
            Statement stmt = null;
            List<Statement> updateStatements = new ArrayList<Statement>();

            if(forStmt.basicForStatement().forInit().localVariableDeclaration() != null) {
                declaration = Driver.declarationVisitor.visitLocalVariableDeclaration(
                                forStmt.basicForStatement().forInit().localVariableDeclaration()).get(0);
            }
            if (forStmt.basicForStatement().forInit().statementExpressionList() != null ) {
                for(Java8Parser.StatementExpressionContext stCtx : forStmt.basicForStatement().forInit().statementExpressionList().statementExpression()) {
                    Statement initStmt = new ExpressionStatement(forStmt.start.getLine(), Driver.expressionVisitor.visitStatementExpression(stCtx));
                    initStatements.add(initStmt);
                }
            }
            if(forStmt.basicForStatement().expression() != null) {
                exp = Driver.expressionVisitor.visitExpression(forStmt.basicForStatement().expression());
            }
            if(forStmt.basicForStatement().forUpdate() != null) {
                for(Java8Parser.StatementExpressionContext expCtx : forStmt.basicForStatement().forUpdate().statementExpressionList().statementExpression()) {
                    Statement update = new ExpressionStatement(forStmt.start.getLine(), Driver.expressionVisitor.visitStatementExpression(expCtx));
                    updateStatements.add(update);
                }
            }
            stmt = visitStatement(forStmt.basicForStatement().statement());

            return new ForStatement(forStmt.start.getLine(), declaration, initStatements, exp, stmt, updateStatements);

        } else {

            Statement stmt = visitStatement(forStmt.enhancedForStatement().statement());
            Expression exp = Driver.expressionVisitor.visitExpression(forStmt.enhancedForStatement().expression());
            String var = forStmt.enhancedForStatement().variableDeclaratorId().Identifier().getSymbol().getText();

            return new ForEachStatement(forStmt.start.getLine(), exp, stmt, var);
        }
    }

    private TryStatement handleTryStatement(Java8Parser.TryStatementContext ctx) {

        Block tryBlock = Driver.blockVisitor.visitBlockStatements(ctx.block().blockStatements());
        List<CatchStatement> catches = new ArrayList<CatchStatement>();
        Block finallyBlock = null;
        List<AssignmentExpression> resources = new ArrayList<AssignmentExpression>();

        if(ctx.catches() != null) {

            for(Java8Parser.CatchClauseContext catchCtx : ctx.catches().catchClause()) {
                Block catchBlock = Driver.blockVisitor.visitBlockStatements(catchCtx.block().blockStatements());
                Identifier id = new Identifier(ctx.start.getLine(), catchCtx.catchFormalParameter().variableDeclaratorId().Identifier().getSymbol().getText());

                catches.add(new CatchStatement(ctx.start.getLine(), id, catchBlock));
            }
        }
        if(ctx.finally_() != null) {
            finallyBlock = Driver.blockVisitor.visitBlockStatements(ctx.finally_().block().blockStatements());
        }
        if(ctx.resourceSpecification() != null) {
            for (Java8Parser.ResourceContext resource : ctx.resourceSpecification().resourceList().resource()) {
                Expression exp = Driver.expressionVisitor.visitExpression(resource.expression());
                Identifier id = new Identifier(ctx.start.getLine(), resource.variableDeclaratorId().Identifier().getSymbol().getText());
                resources.add(new AssignmentExpression(ctx.start.getLine(), id, "=", exp));
            }
        }

        return new TryStatement(ctx.start.getLine(), tryBlock, catches, finallyBlock, resources);
    }

}
