package ast;

import ast.expressions.left.Left;
import ast.interfaces.BlockStatement;
import ast.statements.DeclarationStatement;
import cfg.CFGBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassObject implements BlockStatement {

    public List<Method> methods;
    public List<DeclarationStatement> decls;
    private String className;
    String file;

    public ClassObject(String file, List<Method> methods, List<DeclarationStatement> decls, String className) {
        this.file = file;
        this.methods = methods;
        this.decls = decls;
        this.className = className;

        for(DeclarationStatement decl:decls) {
            System.out.println(decl.toString());
        }
    }

    public void printAST() {
        System.out.println("Class");
        for(Method method: methods) {
            method.printAST();
        }
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        for(DeclarationStatement decl : decls) {
            block = decl.generateCFG(block, finalBlock, labelMap, start, scope);
        }

        return block;
    }

    public String getName() {
        return className;
    }
}
