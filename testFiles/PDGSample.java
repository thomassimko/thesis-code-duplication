package testFiles;

public class PDGSample {

    public void print() {
        int sum = 0;
        int i = 1;
        while(i < 11) {
            sum = sum + i;
            i = i + 1;
        }
        System.out.println(sum);
        System.out.println(i);
    }

}
