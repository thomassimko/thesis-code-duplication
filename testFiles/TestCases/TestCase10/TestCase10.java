public class TestCase10 {
    /*

    Test 10: Reverse Condition with NOT

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

        int sum = 0;
        int count = 0;

        for(int i = 0; !(i >= 3); i++) {
            sum = sum + arr[i];
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;
    }
}