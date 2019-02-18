package ast.expressions;

import ast.ClassObject;
import ast.expressions.left.Identifier;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassInstanceExpression extends Expression {

    private ClassObject classObject;
    private Expression expNames;
    private List<Expression> args;
    private Identifier className;

    public ClassInstanceExpression(int line, Expression expNames, List<Expression> args, ClassObject obj, Identifier className) {
        super(line);
        this.expNames = expNames;
        this.args = args;
        this.classObject = obj;
        this.className = className;
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
        System.err.println("line: " + line);
        output.append("new ");
        output.append(className.toString() + "(");
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

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        for(int i = 0; i < args.size(); i++) {
            args.set(i, Expression.getScopeId(scope, args.get(i)));
        }
    }

    @Override
    public void setUsesAndDefines() {
        for(Expression exp: args) {
            addSource(exp);
        }
    }
}
