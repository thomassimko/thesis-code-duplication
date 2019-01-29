package ast.statements;

import ast.Declaration;
import cfg.CFGBlock;

import java.util.HashMap;

public class DeclarationStatement extends Statement {
    private Declaration decl;
    private Statement stmt;

    public DeclarationStatement(int line, Declaration decl, Statement stmt) {
        super(line);
        this.decl = decl;
        this.stmt = stmt;

    }

    public void printAST() {
        System.out.println("Declaration");
        decl.printAST();
        stmt.printAST();
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {
        CFGBlock declBlock = decl.generateCFG(block, finalBlock, labelMap);
        CFGBlock stmtBlock = stmt.generateCFG(declBlock, finalBlock, labelMap);
        return stmtBlock;
    }
}
