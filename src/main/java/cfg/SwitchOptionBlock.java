package cfg;

import ast.switchObjects.SwitchOption;

public class SwitchOptionBlock extends CFGBlock {

    private SwitchOption option;

    public SwitchOptionBlock(SwitchOption option) {
        super("switch option");
        this.option = option;
    }
}
