package testFiles;

public class testObject {

    int num;
    String text;

    public testObject(int num) {
        this.num = num;
    }

    public void doSomething(String text) {
        System.out.println("Doing something");
        text = text + "\n";
        this.text = text + "banana";
    }
}
