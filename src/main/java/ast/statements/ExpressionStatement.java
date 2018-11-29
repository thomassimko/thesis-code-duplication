package ast.statements;

import ast.expressions.Expression;

public class ExpressionStatement extends Statement {

    private Expression exp;

    public ExpressionStatement(int line, Expression exp) {
        super(line);
        this.exp = exp;
    }

    public void printAST() {
        System.out.println("Expression Statement");
        if(exp != null)
            exp.printAST();
    }
}
