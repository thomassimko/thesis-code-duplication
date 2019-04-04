public class TestCase11 {
    /*

    Test 11: Check auto initialization

     */
    public double test1(int[] arr) {

        int sum = 0;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;


    }
    public double test2(int[] arr) {

        int sum;
        int count;

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;
    }
}