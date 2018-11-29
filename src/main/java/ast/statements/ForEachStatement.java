package ast.statements;

import ast.expressions.Expression;

public class ForEachStatement extends Statement {

    private Expression exp;
    private Statement body;
    private String declaredId = null;

    public ForEachStatement(int line, Expression exp, Statement body, String declaredId) {
        super(line);
        this.exp = exp;
        this.declaredId = declaredId;
        this.body = body;
    }

    public void printAST() {
        System.out.println("For each: " + declaredId);
        exp.printAST();
        body.printAST();
    }
}
