package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.LoopBlock;
import cfg.StartBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForStatement extends Statement {

    private DeclarationStatement declaration = null;
    private List<Statement> initStatements = null;
    private Expression exp = null;
    private Statement body = null;
    private List<Statement> updateStatements = null;

    public ForStatement(String file, int line, DeclarationStatement decl, List<Statement> initStatements, Expression exp, Statement body, List<Statement> updateStatements) {
        super(file, line);
        this.declaration = decl;
        this.initStatements = initStatements;
        this.exp = exp;
        this.body = body;
        this.updateStatements = updateStatements;
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);

        CFGBlock initBlock = new BasicBlock("ForInit");
        CFGBlock condBlock = new BasicBlock("ForCond");
        CFGBlock loopBlock = new LoopBlock();
        CFGBlock outBlock = new BasicBlock();

        start.addBlock(initBlock);
        start.addBlock(condBlock);
        start.addBlock(loopBlock);
        start.addBlock(outBlock);

        //initialize loop
        if(declaration != null)
            initBlock = declaration.generateCFG(initBlock, finalBlock, labelMap, start, scope);
        for(Statement stmt: initStatements) {
            initBlock = stmt.generateCFG(initBlock, finalBlock, labelMap, start, scope);
        }

        //condition block -- only has condition in it
        exp = Expression.getScopeId(scope, exp);
        condBlock.addExpression(exp);


        //main loop -- add updates to end
        CFGBlock endBlock = body.generateCFG(loopBlock, finalBlock, labelMap, start, scope);

        for(Statement stmt: updateStatements) {
            endBlock = stmt.generateCFG(endBlock, finalBlock, labelMap, start, scope);
        }

        block.addSuccessor(initBlock);
        initBlock.addSuccessor(condBlock);
        condBlock.addSuccessor(loopBlock);
        condBlock.addSuccessor(outBlock);
        endBlock.addSuccessor(condBlock);

        popScope(scope);

        return outBlock;
    }
}
