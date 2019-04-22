public class TestCase2 {
     /*

    Test 2: Variable Names Changed

    Both methods are clones of one another with different variable names

     */

    public double test1(int[] arr) {
        int sum1 = 0;
        int count1 = 0;

        for(int i = 0; i < 3; i++) {
            sum1 = sum1 + arr[i];
            count1++;
        }

        double average1 = (sum1 * 1.0) / count1;

        return average1;
    }

    public double test2(int arr[]) {
        int sum2 = 0;
        int count2 = 0;

        for(int i = 0; i < 3; i++) {
            sum2 = sum2 + arr[i];
            count2++;
        }

        double average2 = (sum2 * 1.0) / count2;

        return average2;
    }
}