import ast.ClassObject;
import ast.TypeDeclaration;

public class MyTypeDeclarationVisitor extends Java8BaseVisitor<ClassObject> {

    @Override
    public ClassObject visitTypeDeclaration(Java8Parser.TypeDeclarationContext ctx) {
        return Driver.classDeclarationVisitor.visitClassDeclaration(ctx.classDeclaration());
        //ctx.classDeclaration().normalClassDeclaration().classBody().
        //System.out.println(ctx.getText());
        //return null;
    }
}
