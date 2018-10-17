package ast.statements;

import ast.Block;
import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class SynchronizedStatement implements Statement {

    private Block block;
    private Expression exp;

    public SynchronizedStatement(Block block, Expression exp) {
        this.block = block;
        this.exp = exp;
    }
}
