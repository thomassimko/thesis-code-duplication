package ast.interfaces;

import ast.expressions.left.Left;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BlockStatement {

    public void printAST();

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope);
}
