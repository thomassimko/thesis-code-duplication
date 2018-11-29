package ast.expressions;

import java.util.List;

public class ArrayAccessExpression extends Expression {

    private Expression left;
    private List<Expression> accessors;

    public ArrayAccessExpression(int line, Expression left, List<Expression> accessors) {
        super(line);
        this.left = left;
        this.accessors = accessors;
    }

    @Override
    public void printAST() {
        System.out.println("Array Access: ");
        left.printAST();
        for(Expression accessor: accessors) {
            System.out.print("[");
            accessor.printAST();
            System.out.println("]");
        }
    }
}
