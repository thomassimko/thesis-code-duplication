import ast.Block;
import ast.ClassObject;
import ast.Method;
import ast.statements.DeclarationStatement;

import java.util.ArrayList;
import java.util.List;

public class MyClassDeclarationVisitor extends Java8BaseVisitor<ClassObject> {

    @Override
    public ClassObject visitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        //System.out.println(ctx.normalClassDeclaration().classModifier().get(0).getText());
        Java8Parser.ClassBodyContext body = ctx.normalClassDeclaration().classBody();

        //System.out.println(body.getText());
        return this.visitClassBody(body, ctx.normalClassDeclaration().Identifier().getText());
    }

    public ClassObject visitClassBody(Java8Parser.ClassBodyContext ctx, String className) {

        List<Method> methods = new ArrayList<Method>();
        List<DeclarationStatement> decls = new ArrayList<DeclarationStatement>();

        for(Java8Parser.ClassBodyDeclarationContext bl : ctx.classBodyDeclaration()) {
            //Ignore constructors
            if(bl.classMemberDeclaration() != null) {
                if (bl.classMemberDeclaration().fieldDeclaration() != null) {
                    decls.addAll(Driver.declarationVisitor.visitVariableDeclaratorList(bl.classMemberDeclaration().fieldDeclaration().variableDeclaratorList()));
                }
                else if (bl.classMemberDeclaration().methodDeclaration() != null) {
                    methods.add(Driver.methodVisitor.visitMethodDeclaration(bl.classMemberDeclaration().methodDeclaration()));
                }
            }
        }

        return new ClassObject(Driver.currentFileName, methods, decls, className);
    }
}
