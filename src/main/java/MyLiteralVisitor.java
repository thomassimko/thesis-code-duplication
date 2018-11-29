import ast.literal.Literal;
import ast.literal.*;

public class MyLiteralVisitor extends Java8BaseVisitor<Literal> {

    @Override
    public Literal visitLiteral(Java8Parser.LiteralContext ctx) {
        if(ctx.BooleanLiteral() != null) {
            return new BooleanLiteral(ctx.start.getLine(), ctx.BooleanLiteral().getText().equals("true"));
        } else if (ctx.CharacterLiteral() != null) {
            return new CharacterLiteral(ctx.start.getLine(), ctx.CharacterLiteral().getText().charAt(0));
        } else if (ctx.FloatingPointLiteral() != null) {
            return new FloatLiteral(ctx.start.getLine(), Float.parseFloat(ctx.FloatingPointLiteral().getText()));
        } else if (ctx.IntegerLiteral() != null) {
            return new IntLiteral(ctx.start.getLine(), Integer.parseInt(ctx.IntegerLiteral().getText()));
        } else if (ctx.NullLiteral() != null) {
            return new NullLiteral(ctx.start.getLine());
        } else if (ctx.StringLiteral() != null) {
            return new StringLiteral(ctx.start.getLine(), ctx.StringLiteral().getText());
        }
        System.err.println("no literal value condition for " + ctx.getText());
        return super.visitLiteral(ctx);
    }
}
