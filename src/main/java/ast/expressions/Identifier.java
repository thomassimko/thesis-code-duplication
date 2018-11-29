package ast.expressions;

public class Identifier extends Expression {

    private String id;

    public Identifier(int line, String id) {
        super(line);
        this.id = id;
    }

    @Override
    public void printAST() {
        System.out.println("id: " + id);
    }
}
