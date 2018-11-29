package ast.statements;

import ast.expressions.Expression;

public class DoStatement extends Statement {
    private Statement stmt;
    private Expression exp;

    public DoStatement(int line, Statement stmt, Expression exp) {
        super(line);
        this.stmt = stmt;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("do");
        exp.printAST();
        stmt.printAST();
    }
}
