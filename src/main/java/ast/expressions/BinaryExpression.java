package ast.expressions;

import ast.expressions.left.Left;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryExpression extends Expression {

    private String operator;
    private Expression left;
    private Expression right;

    private HashMap<String, String> operatorReverse;
    private HashMap<String, String> operatorNegated;

    public BinaryExpression(String file, int line, String operator, Expression left, Expression right) {
        super(file, line);
        this.operator = operator;
        this.left = left;
        this.right = right;
        operatorReverse = new HashMap<>();
        operatorReverse.put("<", ">");
        operatorReverse.put(">", "<");
        operatorReverse.put("<=", ">=");
        operatorReverse.put(">=", "<=");

        operatorNegated = new HashMap<>();
        operatorNegated.put("<", ">=");
        operatorNegated.put(">", "<=");
        operatorNegated.put("<=", ">");
        operatorNegated.put(">=", "<");
    }

    @Override
    public String toString() {
        return left.toString() + " " + operator + " " + right.toString();
    }

//    @Override
//    public List<Expression> getExpressions() {
//        List<Expression> output = new ArrayList<Expression>();
//        output.addAll(left.getExpressions());
//        output.addAll(right.getExpressions());
//        output.add(this);
//        return output;
//    }

    @Override
    public void setScopeId(List<Map<String, Left>> scope) {
        right = getScopeId(scope, right);
        left = getScopeId(scope, left);
    }

    @Override
    public void setUsesAndDefines() {

        setUseAndDefineForChild(left);
        setUseAndDefineForChild(right);

        addSource(left);
        addSource(right);
    }

    @Override
    public Expression transformToTemp(List<Expression> expressions) {
        left = left.transformToTemp(expressions);
        right = right.transformToTemp(expressions);
        return this;
    }

    @Override
    public int graphicalCompareTo(Expression o) {
        if(o instanceof BinaryExpression) {
            BinaryExpression bin = (BinaryExpression) o;
            if(operator.equals(bin.operator)) {
                return left.graphicalCompareTo(bin.left) == 0 ? right.graphicalCompareTo(bin.right) : -1;
            } else if(operatorReverse.containsKey(operator) && operatorReverse.get(operator).equals(bin.operator)) {
                return left.graphicalCompareTo(bin.right) == 0 ? right.graphicalCompareTo(bin.left) : -1;
            }
        }
        return -1;
    }
}
