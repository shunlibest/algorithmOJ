package com.数组;

public class Code4_寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] array1 = {1, 2,};
        int[] array2 = {3, 4};
        double medianSortedArrays = new Code4_寻找两个正序数组的中位数().findMedianSortedArrays(array1, array2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int middle = (nums1.length + nums2.length) / 2;
        boolean single = (nums1.length + nums2.length) % 2 == 1;
        int num1Index = 0;
        int num2Index = 0;
        int value = 0;
        int beforeValue = 0;
        for (int i = 0; i <= middle; i++) {
            beforeValue = value;
            if (getOrDefault(nums1, num1Index, Integer.MAX_VALUE) < getOrDefault(nums2, num2Index, Integer.MAX_VALUE)) {
                value = nums1[num1Index];
                num1Index++;
            } else {
                value = nums2[num2Index];
                num2Index++;
            }
        }
        if (single) {
            return value;
        } else {
            return (beforeValue + value) / 2.0;
        }
    }

    private int getOrDefault(int[] array, int index, int defaultValue) {
        if (index < 0 || index > array.length - 1) {
            return defaultValue;
        }
        return array[index];
    }

}
