package ast.statements;

import ast.Block;
import ast.expressions.Expression;

public class SynchronizedStatement extends Statement {

    private Block block;
    private Expression exp;

    public SynchronizedStatement(int line, Block block, Expression exp) {
        super(line);
        this.block = block;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Synchronized: ");
        exp.printAST();
        block.printAST();
    }
}
