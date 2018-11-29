package ast.expressions;

public abstract class Expression {

    int line;

    public Expression(int line) {
        this.line = line;
    }

    public abstract void printAST();

}
