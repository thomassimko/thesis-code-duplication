public class TestCase6 {
    /*

    Test 6: For vs while

    One uses for loop other uses while

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
        int i = 0;


        while(i < 3) {
            sum = sum + arr[i];
            count++;
            i++;
        }

        double average = (sum * 1.0) / count;

        return average;
    }
}