package ast.statements;

import ast.Block;
import ast.expressions.AssignmentExpression;
import ast.interfaces.Statement;

import java.util.List;

public class TryStatement implements Statement {

    private Block tryBlock;
    private List<CatchStatement> catches;
    private Block finallyBlock;
    private List<AssignmentExpression> resources;

    public TryStatement(Block tryBlock, List<CatchStatement> catches, Block finallyBlock, List<AssignmentExpression> resources) {
        this.tryBlock = tryBlock;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
        this.resources = resources;
    }
}
