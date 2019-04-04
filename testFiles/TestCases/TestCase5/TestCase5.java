public class TestCase5 {
    /*

    Test 5: Method call changed

    Both methods are the exact same but the method calls are changed

     */
    public int doSomething1(int x){
        return x+1;
    }
    public void doSomething2(int x){
        return x+1;
    }

    public void test1(int[] arr){
        int sum=0;

        for(int i=0;i< 3;i++){
            sum=sum+arr[i];
            count=doSomething1(count);
        }

        double average=(sum*1.0)/count;

        return average;
    }

    public void test2(int[] arr){
        int sum = 0;
        int count = 0;

        for(int i=0;i< 3;i++){
            sum=sum+arr[i];
            count=doSomething2(count);
        }

        double average=(sum*1.0)/count;

        return average;
    }
}