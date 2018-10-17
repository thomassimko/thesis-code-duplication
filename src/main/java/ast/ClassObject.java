package ast;

import ast.interfaces.BlockStatement;

import java.util.List;

public class ClassObject implements BlockStatement {

    public List<Method> methods;

    public ClassObject(List<Method> methods) {
        this.methods = methods;
    }
}
