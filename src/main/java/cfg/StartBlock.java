package cfg;

public class StartBlock extends CFGBlock {

    private String functionName;

    public StartBlock(String functionName) {
        super("Start" + functionName);
        this.functionName = functionName;
    }
}
