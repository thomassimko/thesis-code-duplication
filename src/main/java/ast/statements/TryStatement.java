package ast.statements;

import ast.Block;
import ast.expressions.AssignmentExpression;

import java.util.List;

public class TryStatement extends Statement {

    private Block tryBlock;
    private List<CatchStatement> catches;
    private Block finallyBlock;
    private List<AssignmentExpression> resources;

    public TryStatement(int line, Block tryBlock, List<CatchStatement> catches, Block finallyBlock, List<AssignmentExpression> resources) {
        super(line);
        this.tryBlock = tryBlock;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
        this.resources = resources;
    }

    public void printAST() {
        System.out.println("Try");
        for(AssignmentExpression resource:resources) {
            resource.printAST();
        }
        for(CatchStatement stmt: catches) {
            stmt.printAST();
        }
        finallyBlock.printAST();
    }
}
