import ast.Program;
import ast.TypeDeclaration;

import java.util.ArrayList;
import java.util.List;

public class MyVisitor extends Java8BaseVisitor<Program> {

    @Override
    public Program visitCompilationUnit(Java8Parser.CompilationUnitContext ctx) {

        List<TypeDeclaration> typeDeclarations = this.gatherTypeDecs(ctx.typeDeclaration());
        Program program = new Program(typeDeclarations);
        return program;
    }

    private List<TypeDeclaration> gatherTypeDecs(List<Java8Parser.TypeDeclarationContext> ctxList) {

        List<TypeDeclaration> types = new ArrayList<TypeDeclaration>();
        for(Java8Parser.TypeDeclarationContext ctx : ctxList) {
            types.add(Driver.typeVisitor.visitTypeDeclaration(ctx));
        }
        return types;

    }
}
