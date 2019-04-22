public class TestCase3 {
     /*

    Test 3: Type Changed

    Both methods are clones of one another with different types

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

    public float test2(int[] arr) {
        long sum = 0;
        int count = 0;

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];
            count++;
        }

        float average = (float) ((sum * 1.0) / count);

        return average;
    }
}