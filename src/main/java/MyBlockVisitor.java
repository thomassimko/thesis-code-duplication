import ast.Block;
import ast.interfaces.BlockStatement;

import java.util.ArrayList;
import java.util.List;

public class MyBlockVisitor extends Java8BaseVisitor<Block> {

    @Override
    public Block visitBlockStatements(Java8Parser.BlockStatementsContext ctx) {

        List<BlockStatement> blockStmts = new ArrayList<BlockStatement>();

        for(Java8Parser.BlockStatementContext blk : ctx.blockStatement()) {

            if(blk.statement() != null) {
                blockStmts.add(Driver.statementVisitor.visitStatement(blk.statement()));
            }
            if(blk.localVariableDeclarationStatement() != null) {

                blockStmts.addAll(Driver.declarationVisitor.visitLocalVariableDeclaration(blk.localVariableDeclarationStatement().localVariableDeclaration()));

            }
            if(blk.classDeclaration() != null) {
                blockStmts.add(Driver.classDeclarationVisitor.visitClassDeclaration(blk.classDeclaration()));
            }
        }

        return new Block(blockStmts);
    }
}
