package ast;

import cfg.*;

import java.util.HashMap;

public class Method {

    private Block body;
    private String name;

    public Method(String name, Block block) {
        this.name = name;
        this.body = block;
    }

    public void printAST() {
        body.printAST();
    }

    public String getName() {
        return name;
    }

    public CFGBlock buildCFG(StartBlock start) {

        HashMap<String, CFGBlock> labelMap = new HashMap<String, CFGBlock>();

        CFGBlock bodyBlock = new BasicBlock();
        EndBlock endBlock = new EndBlock();

        start.addSuccessor(bodyBlock);

        CFGBlock finalBlock = body.generateCFG(bodyBlock, endBlock, labelMap, start);

        if(!(finalBlock instanceof EndBlock))
            finalBlock.addSuccessor(endBlock);

        return start;
    }
}
