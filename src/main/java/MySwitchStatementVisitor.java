import ast.Block;
import ast.expressions.Expression;
import ast.statements.SwitchStatement;
import ast.switchObjects.SwitchLabel;
import ast.switchObjects.SwitchLabelExpression;
import ast.switchObjects.SwitchLabelId;
import ast.switchObjects.SwitchOption;

import java.util.ArrayList;
import java.util.List;

public class MySwitchStatementVisitor extends Java8BaseVisitor<SwitchStatement> {

    @Override
    public SwitchStatement visitSwitchStatement(Java8Parser.SwitchStatementContext ctx) {

        Expression exp = Driver.expressionVisitor.visitExpression(ctx.expression());

        List<SwitchOption> options = new ArrayList<SwitchOption>();

        //TODO: ASK check that this makes sense

        for(Java8Parser.SwitchBlockStatementGroupContext blk : ctx.switchBlock().switchBlockStatementGroup()) {

            Block block = Driver.blockVisitor.visitBlockStatements(blk.blockStatements());
            List<SwitchLabel> labels = new ArrayList<SwitchLabel>();

            for(Java8Parser.SwitchLabelContext label : blk.switchLabels().switchLabel()) {
                labels.add(handleSwitchLabel(label));
            }

            options.add(new SwitchOption(ctx.start.getLine(), labels, block));

        }

        for(Java8Parser.SwitchLabelContext label : ctx.switchBlock().switchLabel()) {
            List<SwitchLabel> labels = new ArrayList<SwitchLabel>();
            labels.add(handleSwitchLabel(label));
            options.add(new SwitchOption(ctx.start.getLine(), labels, null));
        }

        return new SwitchStatement(ctx.start.getLine(), exp, options);
    }

    private SwitchLabel handleSwitchLabel(Java8Parser.SwitchLabelContext label) {
        if(label.constantExpression() != null) {
            return new SwitchLabelExpression(label.start.getLine(), Driver.expressionVisitor.visitExpression(label.constantExpression().expression()));
        }
        return new SwitchLabelId(label.start.getLine(), label.enumConstantName().Identifier().getSymbol().getText());
    }


}
