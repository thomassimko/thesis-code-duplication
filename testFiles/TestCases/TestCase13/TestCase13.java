public class TestCase13 {
    /*

    Test 11: Check if statement set to false

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

        if(false) {
            sum = 40;
        }

        for(int i = 0; i < 3; i++) {
            sum = sum + arr[i];

            if(false) {
                sum = 0;
                count = 0;
            }
            count++;
        }

        double average = (sum * 1.0) / count;

        return average;


    }
}