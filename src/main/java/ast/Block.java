package ast;

import ast.interfaces.BlockStatement;
import ast.interfaces.Statement;

import java.util.List;

public class Block implements Statement {

    private List<BlockStatement> statements;

//    private Statement statement;
//    private ClassObject classDecl;
//    private List<Declaration> declarationList;

    public Block(List<BlockStatement> statements) {
        this.statements = statements;
    }

}
