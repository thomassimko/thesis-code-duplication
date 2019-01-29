package ast.interfaces;

import cfg.CFGBlock;

import java.util.HashMap;

public interface BlockStatement {

    public abstract void printAST();

    public abstract CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap);
}
