package ast.statements;

import ast.expressions.Expression;

public class ConditionalStatement extends Statement{

    private Expression condition;
    private Statement ifTrue;
    private Statement ifFalse;

    public ConditionalStatement(int line, Expression condition, Statement ifTrue, Statement ifFalse) {
        super(line);
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }

    public void printAST() {
        System.out.println("conditional: ");
        condition.printAST();
        ifTrue.printAST();

        if(ifFalse != null)
            ifFalse.printAST();
    }
}
