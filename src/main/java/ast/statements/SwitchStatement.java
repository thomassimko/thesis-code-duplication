package ast.statements;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import ast.switchObjects.SwitchOption;
import cfg.BasicBlock;
import cfg.CFGBlock;
import cfg.StartBlock;
import cfg.SwitchOptionBlock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwitchStatement extends Statement {

    private List<SwitchOption> options;
    private Expression exp;

    public SwitchStatement(String file, int line, Expression exp, List<SwitchOption> options) {
        super(file, line);
        this.options = options;
        this.exp = exp;
    }

    public CFGBlock generateCFG(CFGBlock block, CFGBlock finalBlock, HashMap<String, CFGBlock> labelMap, StartBlock start, List<Map<String, Left>> scope) {

        pushScope(scope);
        CFGBlock endBlock = new BasicBlock();

        exp = Expression.getScopeId(scope, exp);
        block.addExpression(exp);

        for(SwitchOption option: options) {
            pushScope(scope);
            SwitchOptionBlock optionBlock = new SwitchOptionBlock(option);
            CFGBlock newBlock = option.generateCFG(optionBlock, finalBlock, start, scope);

            block.addSuccessor(optionBlock);
            newBlock.addSuccessor(endBlock);
            popScope(scope);
        }
        popScope(scope);


        return endBlock;
    }
}
