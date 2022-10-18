package com.leetcode;

public class BinarySearch {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        int result = search(input, 4);
        System.out.println(result);
    }

    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            }
            if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

}
