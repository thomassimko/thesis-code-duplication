package ast.expressions;

import ast.ClassObject;

import java.util.ArrayList;
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
        if(expNames != null) {
            System.out.println("Expression Names:");
            expNames.printAST();
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("new ");
        output.append(classObject.toString() + "(");
        for(Expression arg:args) {
            output.append(arg.toString() + ", ");
        }
        output.append(")");
        return output.toString();
    }

    @Override
    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();

        for(Expression arg: args) {
            output.addAll(arg.getExpressions());
        }
        output.add(this);
        return output;
    }
}
