package cfg;

import java.util.ArrayList;
import java.util.List;

public class StartBlock extends CFGBlock {

    private String functionName;
    private List<CFGBlock> methodBlocks;

    public StartBlock(String functionName) {
        super("Start" + functionName);
        this.functionName = functionName;
        methodBlocks = new ArrayList<CFGBlock>();
        methodBlocks.add(this);
    }

    public void addBlock(CFGBlock block) {
        methodBlocks.add(block);
    }

    public List<CFGBlock> getMethodBlocks() {
        return methodBlocks;
    }
}
