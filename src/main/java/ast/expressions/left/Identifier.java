package ast.expressions.left;

import ast.expressions.Expression;

import java.util.ArrayList;
import java.util.List;

public class Identifier extends Left {

    private String id;

    public Identifier(int line, String id) {
        super(line);
        this.id = id;
    }

    @Override
    public void printAST() {
        System.out.println("id: " + id);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
