package ast.switchObjects;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

public class SwitchLabelId extends SwitchLabel {

    private String id;

    public SwitchLabelId(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("Option ID: " + id);
    }

    @Override
    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope) {
        //TODO: Idk what to do here for enum
        return prev;
    }
}
