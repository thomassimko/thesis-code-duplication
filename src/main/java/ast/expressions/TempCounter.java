package ast.expressions;

import ast.expressions.left.Identifier;

import java.util.List;

public class TempCounter {

    private static int counter = 1;

    public static Expression getTempWithExpression(String file, int line, Expression exp, List<Expression> expressions) {
        Identifier temp = new Identifier(file, line, "@temp" + counter);
        counter++;
        AssignmentExpression asgn = new AssignmentExpression(file, line, temp, "=", exp);
        expressions.add(asgn);
        return temp;
    }
}
