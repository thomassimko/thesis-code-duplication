package ast;

import ast.expressions.left.Left;
import ast.statements.DeclarationStatement;
import cfg.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Method {

    private Block body;
    private String name;
    private int line;
    private String file;
    private List<DeclarationStatement> params;
    private List<DeclarationStatement> globalVars;

    public Method(String file, int line, String name, List<DeclarationStatement> params, Block block) {
        this.file = file;
        this.line = line;
        this.name = name;
        this.params = params;
        this.body = block;
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }

    public CFGBlock buildCFG(StartBlock start, List<Map<String, Left>> scope) {

        HashMap<String, CFGBlock> labelMap = new HashMap<String, CFGBlock>();

        CFGBlock block = start;
        for(DeclarationStatement global : globalVars) {
            block = global.generateCFGHelper(block, null, null, start, scope, true);
        }


        Map<String, Left> newMap = new HashMap<String, Left>();
        scope.add(newMap);

        CFGBlock bodyBlock = new BasicBlock();

        for(DeclarationStatement stmt : params) {
            //System.err.println("adding param: " + stmt.getVarName());
            scope.get(scope.size() - 1).put(stmt.getVarName().toString(), stmt.getVarName());
            //bodyBlock.addExpression(stmt.getExpression());
        }

        start.addBlock(bodyBlock);
        EndBlock endBlock = new EndBlock();

        start.addSuccessor(bodyBlock);

        CFGBlock finalBlock = body.generateCFG(bodyBlock, endBlock, labelMap, start, scope);

        if(!(finalBlock instanceof EndBlock))
            finalBlock.addSuccessor(endBlock);

        scope.remove(newMap);

        return start;
    }

    public void setGlobalVars(List<DeclarationStatement> globalVars) {
        this.globalVars = globalVars;
    }
}
