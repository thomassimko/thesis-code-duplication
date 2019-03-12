package ast;

import ast.expressions.left.Left;
import ast.interfaces.BlockStatement;
import ast.statements.Statement;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Block extends Statement {

    private List<BlockStatement> statements;

//    private Statement statement;
//    private ClassObject classDecl;
//    private List<DeclarationStatement> declarationList;

    public Block(String file, int line, List<BlockStatement> statements) {
        super(file, line);
        this.statements = statements;
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);
        CFGBlock current = block;

        for(BlockStatement statement : statements) {

            current = statement.generateCFG(current, finalBlock, labelMap, start, scope);
        }
        popScope(scope);

        return current;
    }
}
