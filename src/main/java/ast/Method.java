package ast;

import ast.expressions.left.Left;
import cfg.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public CFGBlock buildCFG(StartBlock start, List<Map<String, Left>> scope) {

        Map<String, Left> newMap = new HashMap<String, Left>();
        scope.add(newMap);

        HashMap<String, CFGBlock> labelMap = new HashMap<String, CFGBlock>();

        CFGBlock bodyBlock = new BasicBlock();
        start.addBlock(bodyBlock);
        EndBlock endBlock = new EndBlock();

        start.addSuccessor(bodyBlock);

        CFGBlock finalBlock = body.generateCFG(bodyBlock, endBlock, labelMap, start, scope);

        if(!(finalBlock instanceof EndBlock))
            finalBlock.addSuccessor(endBlock);

        scope.remove(newMap);

        return start;
    }
}
