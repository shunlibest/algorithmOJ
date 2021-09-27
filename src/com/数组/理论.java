package com.数组;

public class 理论 {

    public static void main(String[] args) {
        test_arr1();
        test_arr2();
    }

    public static void test_arr1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(arr);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }

    public static void test_arr2() {
        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}, {9, 9, 9}};
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }
}
