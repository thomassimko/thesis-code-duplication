package cfg;

import java.util.ArrayList;
import java.util.List;

public class StartBlock extends CFGBlock {

    private String functionName;
    private String className;
    private List<CFGBlock> methodBlocks;
    private String file;

    public StartBlock(String file, String functionName, String className) {
        super("Start" + functionName);
        this.file = file;
        this.functionName = functionName;
        this.className = className;
        methodBlocks = new ArrayList<>();
        methodBlocks.add(this);
    }

    public void addBlock(CFGBlock block) {
        methodBlocks.add(block);
    }

    public List<CFGBlock> getMethodBlocks() {
        return methodBlocks;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getClassName() {
        return className;
    }

    public String getFile() {
        return file;
    }
}
