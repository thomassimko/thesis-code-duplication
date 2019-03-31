package testFiles;

import java.util.*;

public class testFile {

    private static int thing = 2;

    public static void main(String[] args) {
        double that, thisthat;
        int num = 6;
        String banana = "check: " + 6;
        int ham = num + 2;
        if(true) {
            System.out.println(testFile.class);
        }

        if(ham == 0) {
            num = 1;
        } else {
            num = 2;
        }

        myLabel:
        while(true) {
            ham /= 2;
            break myLabel;
        }

        num = getNum(num) == 3 ? 5 : 2;

        testFile.getNum(4 + 3);

        int[] arr = new int[3];

        int useGlobal = thing + 100;

        arr[2] = 4;

        if(true) {
            int thing = 3;
            thing--;
        }

        ++thing;

        int[][] arr1 = new int[4][5];

        arr1[1][2] = 9;

        System.out.println(arr1[0][0]);

        System.out.println(getArray()[0]);

        List<Integer> list = new ArrayList<Integer>();

        int sum = 0;
        for(int x: list) {
            sum += x;
        }

        methodWithManyArgs(sum++, sum--, num++);

        testObject obj = new testObject(5);
        obj.doSomething("bah");
    }

    public static int getNum(int num) {
        for(int i = 0; i < 5; i++) {
            int j;
            if(i == 2) {
                break;
            } else {
                j = 1;
            }
        }
        return num + 1;
    }

    public static int[][] getArray() {
        return new int[][]{{1,2,3}, {4,5,6}};
    }

    public static void methodWithManyArgs(int num1, int num2, int num3) {
        int useGlobal1 = thing + 10000;
        int j = 1;
        j = 2;
        if(j == 3) {

        }
    }

}
