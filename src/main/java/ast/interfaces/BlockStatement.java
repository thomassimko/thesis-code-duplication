package ast.interfaces;

import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;

public interface BlockStatement {

    public abstract void printAST();

    public abstract CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start);
}
