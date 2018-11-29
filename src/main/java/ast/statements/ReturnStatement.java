package ast.statements;

import ast.expressions.Expression;

public class ReturnStatement extends Statement {

    private Expression exp;

    public ReturnStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Return");
        exp.printAST();
    }
}
