package ast.switchObjects;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

public class SwitchLabelId extends SwitchLabel {

    private String id;

    public SwitchLabelId(String file, int line, String id) {
        super(file, line);
        this.id = id;
    }

    @Override
    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope) {
        //TODO: Idk what to do here for enum
        return prev;
    }
}
