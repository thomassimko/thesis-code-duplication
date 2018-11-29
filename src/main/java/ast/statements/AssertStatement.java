package ast.statements;

import ast.expressions.Expression;

public class AssertStatement extends Statement {

    private Expression exp;
    private Expression detail;

    public AssertStatement(int line, Expression exp, Expression detail) {
        super(line);
        this.exp = exp;
        this.detail = detail;
    }

    public void printAST() {
        System.out.println("Assert:");
        exp.printAST();
        detail.printAST();
    }
}
