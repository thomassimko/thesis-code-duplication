import ast.Block;
import ast.ClassObject;
import ast.Method;

import java.util.ArrayList;
import java.util.List;

public class MyClassDeclarationVisitor extends Java8BaseVisitor<ClassObject> {

    @Override
    public ClassObject visitClassDeclaration(Java8Parser.ClassDeclarationContext ctx) {
        //System.out.println(ctx.normalClassDeclaration().classModifier().get(0).getText());
        Java8Parser.ClassBodyContext body = ctx.normalClassDeclaration().classBody();
        //System.out.println(body.getText());
        return new ClassObject(gatherMethods(body));
    }

    public List<Method> gatherMethods(Java8Parser.ClassBodyContext body) {

        List<Method> methods = new ArrayList<Method>();

        for(Java8Parser.ClassBodyDeclarationContext bl : body.classBodyDeclaration()) {

            if(bl.classMemberDeclaration().methodDeclaration() != null) {
                methods.add(Driver.methodVisitor.visitMethodDeclaration(bl.classMemberDeclaration().methodDeclaration()));
            }
        }

        return methods;
    }
}
