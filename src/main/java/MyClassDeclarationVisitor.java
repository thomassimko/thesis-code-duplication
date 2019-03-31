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

        List<Java8Parser.FieldDeclarationContext> fields = new ArrayList<>();

        for(Java8Parser.ClassBodyDeclarationContext bl : ctx.classBodyDeclaration()) {
            if (bl.classMemberDeclaration() != null && bl.classMemberDeclaration().fieldDeclaration() != null) {
                fields.add(bl.classMemberDeclaration().fieldDeclaration());
            }
        }


        for(Java8Parser.ClassBodyDeclarationContext bl : ctx.classBodyDeclaration()) {
            //Ignore constructors
            if(bl.classMemberDeclaration() != null) {
//                if (bl.classMemberDeclaration().fieldDeclaration() != null) {
//                    decls.addAll(Driver.declarationVisitor.visitFieldDeclaration(bl.classMemberDeclaration().fieldDeclaration()));
//                }
                if (bl.classMemberDeclaration().methodDeclaration() != null) {
                    List<DeclarationStatement> decls = new ArrayList<DeclarationStatement>();


                    for(Java8Parser.FieldDeclarationContext field : fields) {
                        decls.addAll(Driver.declarationVisitor.visitFieldDeclaration(field));
                    }
                    Method method = Driver.methodVisitor.visitMethodDeclaration(bl.classMemberDeclaration().methodDeclaration());
                    method.setGlobalVars(decls);

                    methods.add(method);
                }
            }
        }

        return new ClassObject(Driver.currentFileName, methods, className);
    }
}
