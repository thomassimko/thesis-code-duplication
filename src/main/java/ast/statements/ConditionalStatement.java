package ast.statements;

import ast.interfaces.Expression;
import ast.interfaces.Statement;

public class ConditionalStatement implements Statement{

    private Expression condition;
    private Statement ifTrue;
    private Statement ifFalse;

    public ConditionalStatement(Expression condition, Statement ifTrue, Statement ifFalse) {
        this.condition = condition;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }
}
