package ast.statements;

public class ContinueStatement extends Statement {

    private String id;

    public ContinueStatement(int line) {
        super(line);
    }

    public ContinueStatement(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("Continue: " + id);
    }
}
