package ast.switchObjects;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

public abstract class SwitchLabel {

    int line;

    public SwitchLabel(int line) {
        this.line = line;
    }

    public abstract void printAST();

    public abstract CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope);
}
