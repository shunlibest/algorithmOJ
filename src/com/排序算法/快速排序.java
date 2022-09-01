package com.排序算法;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

import static com.排序算法.SortUtils.swap;

public class 快速排序 {

    public static void main(String[] args) {
//        int[] array = new int[]{9, 8, 5, 4, 20};
        int[] array = RandomUtil.randomInts(1000);

        System.out.println();
        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }


    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (array[l] <= pivot) {
                l++;
            } else {
                swap(array, l, r);
                r--;
            }
        }
        swap(array, left, r);

        sort(array, left, r - 1);
        sort(array, r + 1, right);
    }


}
