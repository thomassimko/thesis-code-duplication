package ast;

import ast.interfaces.BlockStatement;

import java.util.List;

public class ClassObject implements BlockStatement {

    public List<Method> methods;

    public ClassObject(List<Method> methods) {
        this.methods = methods;
    }

    public void printAST() {
        System.out.println("Class");
        for(Method method: methods) {
            method.printAST();
        }
    }
}
