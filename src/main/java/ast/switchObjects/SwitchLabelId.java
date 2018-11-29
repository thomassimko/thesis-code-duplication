package ast.switchObjects;

public class SwitchLabelId extends SwitchLabel {

    private String id;

    public SwitchLabelId(int line, String id) {
        super(line);
        this.id = id;
    }

    public void printAST() {
        System.out.println("Option ID: " + id);
    }
}
