package ast.expressions;

import ast.interfaces.LeftSide;
import ast.interfaces.Expression;

public class AssignmentExpression implements Expression {

    private Expression exp;
    private String operator;
    private LeftSide left;

    public AssignmentExpression(LeftSide left, String operator, Expression exp) {
        this.left = left;
        this.operator = operator;
        this.exp = exp;
    }
}
