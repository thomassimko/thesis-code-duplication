package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.Left;
import ast.expressions.left.LeftIdDot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Expression {

    int line;
    String file;
    List<Left> targets;
    List<Left> sources;

    public Expression(String file, int line) {
        this.file = file;
        this.line = line;
        targets = new ArrayList<Left>();
        sources = new ArrayList<Left>();
    }

    public abstract void printAST();

    public abstract String toString();

//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        output.add(this);
//        return output;
//    }

    public int getLine() {
        return line;
    }

    public boolean isIdentifier() {
        return this instanceof Identifier;
    }

    public List<Left> getTargets() {
        return this.targets;
    }
    public List<Left> getSources() {
        return this.sources;
    }

    public void addTarget(Expression exp) {
        if(exp instanceof Left)
            this.targets.add((Left) exp);
    }

    public void addSource(Expression exp) {
        if(exp instanceof Left)
            this.sources.add((Left) exp);
    }

    public static Expression getScopeId(List<Map<String, Left>> scope, Expression exp) {
        if(exp == null) {
            return null;
        }
        if(exp instanceof Left) {
            Left left = (Left) exp;

            for (int i = scope.size() - 1; i >= 0; i--) {
                Map<String, Left> local = scope.get(i);
                if (local.containsKey(left.toString())) {
                    Left var = local.get(left.toString());
                    //System.out.println(left.toString() + " at line " + left.getLine() + " points to " + var.toString() + " which was declared at line " + var.getLine());
                    return var;
                }
            }
        }
        exp.setScopeId(scope);
        return exp;
    }

    public abstract void setScopeId(List<Map<String, Left>> scope);
    public abstract void setUsesAndDefines();

    public void setUseAndDefineForChild(Expression exp) {
        exp.setUsesAndDefines();
        targets.addAll(exp.getTargets());
        sources.addAll(exp.getSources());
    }


    public abstract Expression transformToTemp(List<Expression> expressions);


    //target: assignment expression, post unary, pre unary, method call

}
