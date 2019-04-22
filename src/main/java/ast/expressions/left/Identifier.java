package ast.expressions.left;

import ast.expressions.Expression;
import main.ArgumentHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Identifier extends Left {

    private String id;

    public Identifier(String file, int line, String id) {
        super(file, line);
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }

    public void setScopeId(List<Map<String, Left>> scope) {
        //System.err.println("Get scope id called in Identifier: " + id);
    }

    @Override
    public void setUsesAndDefines() {
        //None
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        return this;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(ArgumentHandler.checkLeft)
            return o instanceof Identifier ? 0 : -1;
        return 0;
    }
}
