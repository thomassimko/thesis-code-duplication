package ast.literal;

import ast.expressions.Expression;
import ast.expressions.left.Left;
import main.ArgumentHandler;

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
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append('{');
        for(Expression exp: expressionList) {
            output.append(exp.toString() + ", ");
        }
        output.append('}');
        return output.toString();
    }

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

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof Left && !ArgumentHandler.checkLeft) {
            return 0;
        }
        return (o instanceof Array) ? 0 : -1;
    }
}
