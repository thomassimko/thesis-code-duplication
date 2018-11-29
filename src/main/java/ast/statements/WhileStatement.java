package ast.statements;

import ast.expressions.Expression;

public class WhileStatement extends Statement {

    private Expression exp;
    private Statement stmt;

    public WhileStatement(int line, Expression exp, Statement stmt) {
        super(line);
        this.stmt = stmt;
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("while: ");
        exp.printAST();
        stmt.printAST();
    }
}
