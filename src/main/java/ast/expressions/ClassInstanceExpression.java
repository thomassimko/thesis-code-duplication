package ast.expressions;

import ast.ClassObject;

import java.util.List;

public class ClassInstanceExpression extends Expression {

    private ClassObject classObject;
    private Expression expNames;
    private List<Expression> args;

    public ClassInstanceExpression(int line, Expression expNames, List<Expression> args, ClassObject obj) {
        super(line);
        this.expNames = expNames;
        this.args = args;
        this.classObject = obj;
    }

    @Override
    public void printAST() {
        System.out.println("Class Instance");
        System.out.println("Args:");
        for(Expression arg: args) {
            arg.printAST();
        }
        System.out.println("Expression Names:");
        expNames.printAST();
    }
}
