package ast;

import ast.expressions.left.Left;
import ast.interfaces.BlockStatement;
import ast.statements.DeclarationStatement;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassObject implements BlockStatement, Comparable<ClassObject> {

    List<Method> methods;
    private List<DeclarationStatement> decls;
    private String className;
    private String file;

    public ClassObject(String file, List<Method> methods, String className) {
        this.file = file;
        this.methods = methods;
        this.className = className;
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        for(DeclarationStatement decl : decls) {
            block = decl.generateCFGHelper(block, finalBlock, labelMap, start, scope, true);
        }

        return block;
    }

    public String getName() {
        return className;
    }

    public int compareTo(ClassObject o) {
        return className.compareTo(o.className);
    }
}
