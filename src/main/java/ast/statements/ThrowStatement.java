package ast.statements;

import ast.expressions.Expression;

public class ThrowStatement extends Statement {

    private Expression exp;

    public ThrowStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Throw:");
        exp.printAST();
    }
}
