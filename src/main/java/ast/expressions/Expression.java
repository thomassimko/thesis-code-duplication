package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {

    int line;
    List<Left> targets;
    List<Left> sources;

    public Expression(int line) {
        this.line = line;
        targets = new ArrayList<Left>();
        sources = new ArrayList<Left>();
    }

    public abstract void printAST();

    public abstract String toString();

    public List<Expression> getExpressions() {
        List<Expression> output = new ArrayList<Expression>();
        output.add(this);
        return output;
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

    //target: assignment expression, post unary, pre unary, method call

}
