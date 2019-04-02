package testFiles;

public class testObject {

    int num;
    String text;

    public testObject(String num) {
        String banana = num;
        num = "hi";
        String yeti = banana + num + this.num;
    }

    public testObject(int num) {
        this.num = num;
    }

    public void doSomething(String text) {
        System.out.println("Doing something");
        text = text + "\n";
        this.text = text + "banana";
        String out = this.text;
    }

    public int testingMethodParams(int num) {
        int next = num + 1;
        return next;
    }
}
