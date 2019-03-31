package ast;

import ast.expressions.left.Left;
import cfg.StartBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Program() {
        this.classes = new ArrayList<>();
    }

    public List<StartBlock> getCFG() {

        List<Map<String, Left>> scope = new ArrayList<Map<String, Left>>();
        Map<String, Left> newMap = new HashMap<String, Left>();
        scope.add(newMap);

        List<StartBlock> block = new ArrayList<StartBlock>();

        for(ClassObject clss : classes) {

            for(Method method: clss.methods) {

                scope = new ArrayList<>();
                newMap = new HashMap<>();
                scope.add(newMap);

                StartBlock start = new StartBlock(method.getName(), clss.getName());

                //does nothing
                //clss.generateCFG(start, null, null, null, scope);

                method.buildCFG(start, scope);
                block.add(start);

            }
        }
        return block;
    }

    public void addClasses(List<ClassObject> classes) {
        this.classes.addAll(classes);
    }

    public List<ClassObject> getClasses() {
        return this.classes;
    }
}
