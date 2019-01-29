package ast.statements;

import ast.Declaration;
import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;

import java.util.HashMap;
import java.util.List;

public class ForStatement extends Statement {

    private Declaration declaration = null;
    private List<Statement> initStatements = null;
    private Expression exp = null;
    private Statement body = null;
    private List<Statement> updateStatements = null;

    public ForStatement(int line, Declaration decl, List<Statement> initStatements, Expression exp, Statement body, List<Statement> updateStatements) {
        super(line);
        this.declaration = decl;
        this.initStatements = initStatements;
        this.exp = exp;
        this.body = body;
        this.updateStatements = updateStatements;
    }

    public void printAST() {
        System.out.println("For");
        declaration.printAST();
        for(Statement stmt: initStatements) {
            stmt.printAST();
        }
        exp.printAST();
        for(Statement stmt: updateStatements) {
            stmt.printAST();
        }
        body.printAST();

    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap) {

        CFGBlock curBlock = block;

        CFGBlock newBlock = new BasicBlock();
        CFGBlock forBlock = new LoopBlock();

        for(Statement stmt: initStatements) {
            curBlock = stmt.generateCFG(curBlock, finalBlock, labelMap);
        }
        curBlock.addExpression(exp);

        for(Statement stmt: updateStatements) {
            curBlock = stmt.generateCFG(curBlock, finalBlock, labelMap);
        }

        CFGBlock endBlock = body.generateCFG(forBlock, finalBlock, labelMap);

        //endBlock.addExpression();
        //TODO: how do i add the update statements to a list of expression?

        block.addSuccessor(forBlock);
        endBlock.addSuccessor(forBlock);
        endBlock.addSuccessor(newBlock);

        return newBlock;
    }
}
