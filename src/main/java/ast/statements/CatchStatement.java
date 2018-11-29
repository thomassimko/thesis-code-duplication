package ast.statements;

import ast.Block;
import ast.expressions.Identifier;

public class CatchStatement extends Statement {

    private Block block;
    private Identifier id;

    public CatchStatement(int line, Identifier id, Block block) {
        super(line);
        this.block = block;
        this.id = id;
    }

    public void printAST() {
        System.out.println("catch: " + id);
        block.printAST();
    }
}
