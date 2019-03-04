package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Array extends Literal {

    private List<Expression> expressionList;

    public Array(String file, int line, List<Expression> values) {
        super(file, line);
        this.expressionList = values;
    }

    @Override
    public void printAST() {
        System.out.println("Array: ");
        for (Expression exp : expressionList) {
            exp.printAST();
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append('{');
        for(Expression exp: expressionList) {
            output.append(exp.toString() + ", ");
        }
        output.append('}');
        return output.toString();
    }

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        for(Expression exp: expressionList) {
//            output.addAll(exp.getExpressions());
//        }
//        output.add(this);
//        return output;
//    }

    @Override
    public void setUsesAndDefines() {
        for(Expression exp: expressionList) {
            setUseAndDefineForChild(exp);
            addSource(exp);
        }
    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        //System.err.println("Array set scope not implemented");
    }
}
