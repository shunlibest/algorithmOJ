package com.数组;

public class Code287_寻找重复数 {


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 4, 2, 2};

        int hint = findDuplicate(array);
        System.out.println(hint);

    }

    public static int findDuplicate(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum = sum ^ n;
        }


        return sum;
    }
}
