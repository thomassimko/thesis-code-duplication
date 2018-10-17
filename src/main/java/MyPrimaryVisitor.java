public class MyPrimaryVisitor extends Java8BaseVisitor {

    @Override
    public Object visitPrimary(Java8Parser.PrimaryContext ctx) {

        //'new' primitiveType dimExprs dims?
        //	|	'new' classOrInterfaceType dimExprs dims?
        //	|	'new' primitiveType dims arrayInitializer
        //	|	'new' classOrInterfaceType dims arrayInitializer


        if(ctx.arrayCreationExpression() != null) {

        }
        else if (ctx.)


        return super.visitPrimary(ctx);
    }
}
