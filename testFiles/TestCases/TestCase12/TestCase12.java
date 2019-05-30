public class TestCase12 {
    /*

    Test 11: Check recursive vs iterative

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
        return (helper(arr, 0) / 3);
    }

    public double helper(int[] arr, int index) {
        if(index >= 3) {
            return 0;
        }
        return helper(arr, index + 1) + arr[index];
    }
}