package ast.switchObjects;

import ast.Block;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.List;

public class SwitchOption {

    int line;
    List<SwitchLabel> caseList;
    Block block;

    public SwitchOption(int line, List<SwitchLabel> caseList, Block block) {
        this.line = line;
        this.caseList = caseList;
        this.block = block;
    }

    public void printAST() {
        for(SwitchLabel label: caseList) {
            label.printAST();
        }
        block.printAST();
    }

    public CFGBlock generateCFG(CFGBlock prev, CFGBlock finalBlock, StartBlock start) {

        return block.generateCFG(prev, finalBlock, null, start);
    }
}
