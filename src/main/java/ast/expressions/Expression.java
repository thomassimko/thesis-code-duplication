package ast.expressions;

import ast.expressions.left.Identifier;
import ast.expressions.left.Left;
import ast.expressions.left.LeftIdDot;
import cfg.CFGBlock;

import java.util.*;

public abstract class Expression {

    int line;
    String file;
    private List<Left> targets;
    private List<Left> sources;
    private Set<Expression> dataDependents;
    private Set<Expression> wawDependents;
    private Set<Expression> dependentOn;

    public Expression(String file, int line) {
        this.file = file;
        this.line = line;
        targets = new ArrayList<>();
        sources = new ArrayList<>();
        dataDependents = new HashSet<>();
        wawDependents = new HashSet<>();
        dependentOn = new HashSet<>();
    }

    public abstract String toString();

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

    public void addDataDependents(Expression exp) {
        this.dataDependents.add(exp);
        exp.dependentOn.add(this);
    }

    public Set<Expression> getDataDependents() {
        return dataDependents;
    }

    public void addWawDependent(Expression exp) {
        this.wawDependents.add(exp);
        exp.dependentOn.add(this);

    }

    public Set<Expression> getWawDependents() {
        return wawDependents;
    }
    public Set<Expression> getDependentOn() {
        return dependentOn;
    }

    public String toGraphVis() {
        return "\"" + this.getLine() + " : " + this.toString().replaceAll("\"", "\\\\\"") + "\"";
    }

    public String getFile() {
        return file;
    }

    public abstract int graphicalCompareTo(Expression exp);

}
