package ast;

import cfg.StartBlock;

import java.util.ArrayList;
import java.util.List;

public class Program {
    //private List<TypeDeclaration> typeDeclarations;
    //private List<Method> methods;

//    public Program(List<TypeDeclaration> typeDeclarations, List<Method> methods) {
//        this.typeDeclarations = typeDeclarations;
//        this.methods = methods;
//    }
//
    private List<ClassObject> classes;

    public Program(List<ClassObject> classes) {
        this.classes = classes;
    }

    public void printProgram() {
        System.out.println("Program: ");
        for(ClassObject clss : classes) {
            clss.printAST();
        }
    }

    public List<StartBlock> getCFG() {

        List<StartBlock> block = new ArrayList<StartBlock>();

        for(ClassObject clss : classes) {
            for(Method method: clss.methods) {

                StartBlock start = new StartBlock(method.getName());
                method.buildCFG(start);
                block.add(start);

            }
        }
        return block;
    }
}
