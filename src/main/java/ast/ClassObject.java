package ast;

import ast.interfaces.BlockStatement;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;

public class ClassObject implements BlockStatement {

    public List<Method> methods;

    public ClassObject(List<Method> methods) {
        this.methods = methods;
    }

    public void printAST() {
        System.out.println("Class");
        for(Method method: methods) {
            method.printAST();
        }
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        StartBlock newStart = new StartBlock(methods.toString());

        for(Method method: methods) {
            method.buildCFG(newStart);
        }

        return block;
    }
}
