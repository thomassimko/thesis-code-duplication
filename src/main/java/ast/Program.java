package ast;

import java.util.List;

public class Program {
    private List<TypeDeclaration> typeDeclarations;

    public Program(List<TypeDeclaration> typeDeclarations) {
        this.typeDeclarations = typeDeclarations;
    }
}
