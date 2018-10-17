package ast.values;

import ast.interfaces.LeftSide;

public class LeftIdDot implements LeftSide {
    private String id;
    private LeftSide left;

    public LeftIdDot(String id, LeftSide left) {
        this.id = id;
        this.left = left;
    }
}
