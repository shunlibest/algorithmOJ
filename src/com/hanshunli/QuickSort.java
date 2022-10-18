package com.hanshunli;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] testValue = new int[]{3, 1, 4, 5, 6, 8};
        sort(testValue, 0, testValue.length - 1);

        System.out.println(Arrays.toString(testValue));
    }

    public static void sort(int[] input, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }
        int middleValue = input[leftIndex];
        int left = leftIndex + 1;
        int right = rightIndex;
        while (left <= right) {
            if (input[left] < middleValue) {
                left++;
            } else {
                swap(input, left, right);
                right--;
            }
        }
        swap(input, leftIndex, right);

        sort(input, leftIndex, right - 1);
        sort(input, right + 1, rightIndex);
    }

    public static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
}
