package ast.statements;

public class LabeledStatement extends Statement {

    private String label;
    private Statement stmt;

    public LabeledStatement(int line, String label, Statement stmt) {
        super(line);
        this.label = label;
        this.stmt = stmt;
    }

    public void printAST() {
        System.out.println("Label: " + label);
        stmt.printAST();
    }
}
