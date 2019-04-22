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

    public ClassInstanceExpression(String file, int line, Expression expNames, List<Expression> args, ClassObject obj, Identifier className) {
        super(file, line);
        this.expNames = expNames;
        this.args = args;
        this.classObject = obj;
        this.className = className;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("new ");
        output.append(className.toString() + "(");
        for(Expression arg:args) {
            output.append(arg.toString() + ", ");
        }
        output.append(")");
        return output.toString();
    }

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//
//        for(Expression arg: args) {
//            output.addAll(arg.getExpressions());
//        }
//        output.add(this);
//        return output;
//    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        for(int i = 0; i < args.size(); i++) {
            args.set(i, Expression.getScopeId(scope, args.get(i)));
        }
    }

    @Override
    public void setUsesAndDefines() {
        for(Expression arg: args) {
            setUseAndDefineForChild(arg);
            addSource(arg);
        }
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return this;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof ClassInstanceExpression) {
            ClassInstanceExpression other = (ClassInstanceExpression) o;
            if(className.graphicalCompareTo(other.className) == 0) {
                if(args.size() == other.args.size()) {
                    for(int i = 0; i < args.size(); i++) {
                        if (args.get(i).graphicalCompareTo(other.args.get(i)) != 0) {
                            return -1;
                        }
                    }
                    return 0;
                }
            }
        }
        return -1;
    }
}
