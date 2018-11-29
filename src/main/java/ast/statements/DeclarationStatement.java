package ast.statements;

import ast.Declaration;

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
}
