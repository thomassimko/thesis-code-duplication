package cfg;

import ast.expressions.Expression;

import java.util.List;

public class BasicBlock extends CFGBlock {

    public BasicBlock() {
        super("Basic");
    }

    public BasicBlock(String type) {
        super(type);
    }
}
