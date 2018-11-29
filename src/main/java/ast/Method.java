package ast;

public class Method {

    private Block block;

    public Method(Block block) {
        this.block = block;
    }

    public void printAST() {
        block.printAST();
    }
}
