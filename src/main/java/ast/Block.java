package ast;

import ast.interfaces.BlockStatement;
import ast.statements.Statement;
import cfg.CFGBlock;

import java.util.HashMap;
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
        System.out.println("CFGBlock");
        for(BlockStatement stmt: statements) {
            stmt.printAST();
        }
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        CFGBlock current = block;

        for(BlockStatement statement : statements) {
            current = statement.generateCFG(current, finalBlock, labelMap);
        }

        return current;
    }
}
