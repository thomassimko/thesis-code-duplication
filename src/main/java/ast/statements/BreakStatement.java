package ast.statements;

public class BreakStatement extends Statement {

    private String id;

    public BreakStatement(int line) {
        super(line);

    }

    public BreakStatement(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("break: " + id);
    }
}
