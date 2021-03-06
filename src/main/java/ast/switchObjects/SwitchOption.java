package ast.switchObjects;

import ast.Block;
import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;
import java.util.Map;

public class SwitchOption {

    int line;
    String file;
    List<SwitchLabel> caseList;
    Block block;

    public SwitchOption(String file, int line, List<SwitchLabel> caseList, Block block) {
        this.line = line;
        this.file = file;
        this.caseList = caseList;
        this.block = block;
    }

    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start, List<Map<String, Left>> scope) {

        for(SwitchLabel label: caseList) {
            prev = label.generateCFG(prev, finalBlock, start, scope);
        }
        return block.generateCFG(prev, finalBlock, null, start, scope);
    }
}
