package ast;

import ast.interfaces.BlockStatement;
import ast.statements.Statement;

import java.util.List;

public class Block extends Statement {

    private List<BlockStatement> statements;

//    private Statement statement;
//    private ClassObject classDecl;
//    private List<Declaration> declarationList;

    public Block(int line, List<BlockStatement> statements) {
        super(line);
        this.statements = statements;
    }

    public void printAST() {
        System.out.println("Block");
        for(BlockStatement stmt: statements) {
            stmt.printAST();
        }
    }
}
