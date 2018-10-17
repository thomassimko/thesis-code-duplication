package ast.values;

import ast.interfaces.LeftSide;

public class Identifier implements LeftSide {

    private String id;

    public Identifier(String id) {
        this.id = id;
    }
}
