package ast.switchObjects;

public abstract class SwitchLabel {

    int line;

    public SwitchLabel(int line) {
        this.line = line;
    }

    public abstract void printAST();

}
