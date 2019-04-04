public class TestCase7 {
    /*

    Test 7: 2-Step Addition vs. 1-Step

     */
    public double test1(int[] arr) {

        int sum = 0;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i] + 3;
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;


    }
    public double test2(int[] arr) {

        int sum = 0;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];
            sum = sum + 3;
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;
    }
}