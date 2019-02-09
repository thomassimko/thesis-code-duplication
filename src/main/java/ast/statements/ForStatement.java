package ast.statements;

import ast.expressions.Expression;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;

public class ForStatement extends Statement {

    private DeclarationStatement declaration = null;
    private List<Statement> initStatements = null;
    private Expression exp = null;
    private Statement body = null;
    private List<Statement> updateStatements = null;

    public ForStatement(int line, DeclarationStatement decl, List<Statement> initStatements, Expression exp, Statement body, List<Statement> updateStatements) {
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

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start) {

        CFGBlock initBlock = new BasicBlock("ForInit");
        CFGBlock condBlock = new BasicBlock("ForCond");
        CFGBlock loopBlock = new LoopBlock();
        CFGBlock outBlock = new BasicBlock();

        start.addBlock(initBlock);
        start.addBlock(condBlock);
        start.addBlock(loopBlock);
        start.addBlock(outBlock);

        //initialize loop
        initBlock.addExpression(declaration.getExpression());
        for(Statement stmt: initStatements) {
            initBlock = stmt.generateCFG(initBlock, finalBlock, labelMap, start);
        }

        //condition block -- only has condition in it
        condBlock.addExpression(exp);


        //main loop -- add updates to end
        CFGBlock endBlock = body.generateCFG(loopBlock, finalBlock, labelMap, start);

        for(Statement stmt: updateStatements) {
            endBlock = stmt.generateCFG(endBlock, finalBlock, labelMap, start);
        }

        block.addSuccessor(initBlock);
        initBlock.addSuccessor(condBlock);
        condBlock.addSuccessor(loopBlock);
        condBlock.addSuccessor(outBlock);
        endBlock.addSuccessor(condBlock);

        return outBlock;
    }
}
