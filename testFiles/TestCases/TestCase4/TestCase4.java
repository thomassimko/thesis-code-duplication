public class TestCase4 {
    /*

    Test 4: Post-Unary increment

    count++ and count = count + 1

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

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];
            count = count + 1;
        }

        double average = (sum * 1.0) / count;

        return average;
    }
}