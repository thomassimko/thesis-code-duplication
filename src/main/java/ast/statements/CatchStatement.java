package ast.statements;

import ast.Block;
import ast.values.Identifier;

public class CatchStatement {

    private Block block;
    private Identifier id;

    public CatchStatement(Identifier id, Block block) {
        this.block = block;
        this.id = id;
    }
}
