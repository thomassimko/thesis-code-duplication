import ast.Block;
import ast.ClassObject;
import ast.Method;
import ast.statements.DeclarationStatement;

import java.util.ArrayList;
import java.util.List;

public class MyClassDeclarationVisitor extends Java8BaseVisitor<ClassObject> {

    @Override
    public ClassObject visitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        Java8Parser.ClassBodyContext body = ctx.normalClassDeclaration().classBody();
        return this.visitClassBody(body, ctx.normalClassDeclaration().Identifier().getText());
    }

    public ClassObject visitClassBody(Java8Parser.ClassBodyContext ctx, String className) {

        List<Method> methods = new ArrayList<Method>();
        int constructorCount = 0;

        List<Java8Parser.FieldDeclarationContext> fields = new ArrayList<>();

        for(Java8Parser.ClassBodyDeclarationContext bl : ctx.classBodyDeclaration()) {
            if (bl.classMemberDeclaration() != null && bl.classMemberDeclaration().fieldDeclaration() != null) {
                fields.add(bl.classMemberDeclaration().fieldDeclaration());
            }
        }


        for(Java8Parser.ClassBodyDeclarationContext bl : ctx.classBodyDeclaration()) {
            Method method = null;
            if(bl.constructorDeclaration() != null) {
                method = handleConstructor(bl.constructorDeclaration(), ++constructorCount);
            }
            else if(bl.classMemberDeclaration() != null && bl.classMemberDeclaration().methodDeclaration() != null) {
                method = Driver.methodVisitor.visitMethodDeclaration(bl.classMemberDeclaration().methodDeclaration());
            }
            if(method != null) {
                method.setGlobalVars(generateDeclList(fields));
                methods.add(method);
            }
        }

        return new ClassObject(Driver.currentFileName, methods, className);
    }

    private List<DeclarationStatement> generateDeclList(List<Java8Parser.FieldDeclarationContext> fields) {
        List<DeclarationStatement> decls = new ArrayList<DeclarationStatement>();


        for(Java8Parser.FieldDeclarationContext field : fields) {
            decls.addAll(Driver.declarationVisitor.visitFieldDeclaration(field));
        }
        return decls;
    }

    private Method handleConstructor(Java8Parser.ConstructorDeclarationContext ctx, int count) {
        if(ctx.constructorBody() == null)
            return null;
        Block block = Driver.blockVisitor.visitBlockStatements(ctx.constructorBody().blockStatements());
        List<DeclarationStatement> params = new ArrayList<>();
        Driver.methodVisitor.handleParameters(ctx.constructorDeclarator().formalParameterList(), params);
        return new Method(Driver.currentFileName, ctx.start.getLine(), "constructor" + count, params, block);
    }
}
