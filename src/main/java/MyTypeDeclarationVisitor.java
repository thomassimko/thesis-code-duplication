import ast.TypeDeclaration;

public class MyTypeDeclarationVisitor extends Java8BaseVisitor<TypeDeclaration> {

    @Override
    public TypeDeclaration visitTypeDeclaration(Java8Parser.TypeDeclarationContext ctx) {
        Driver.classDeclarationVisitor.visitClassDeclaration(ctx.classDeclaration());
        //ctx.classDeclaration().normalClassDeclaration().classBody().
        //System.out.println(ctx.getText());
        return null;
    }
}
