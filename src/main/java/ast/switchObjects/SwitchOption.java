package ast.switchObjects;

import ast.Block;

import java.util.List;

public class SwitchOption {

    List<SwitchLabel> caseList;
    Block block;

    public SwitchOption(List<SwitchLabel> caseList, Block block) {
        this.caseList = caseList;
        this.block = block;
    }
}
