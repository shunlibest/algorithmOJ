package com.排序算法;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

import static com.排序算法.SortUtils.swap;

public class 堆排序 {

    public static void main(String[] args) {
//        int[] array = new int[]{9, 8, 5, 4, 20};
        int[] array = RandomUtil.randomInts(1000);

        System.out.println();
        sort(array);

        System.out.println(Arrays.toString(array));
    }


    private static void sort(int[] array) {
        buildMaxHeap(array);
        for (int i = array.length-1; i > 0 ; i--) {
            swap(array,0,i);
            adjustHeap(array,0,i);
        }
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }
    }

    private static void adjustHeap(int[] array, int root, int heapSize) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;

        int maxValue = root;
        if (left < heapSize && array[left] > array[maxValue]) {
            maxValue = left;
        }
        if (right < heapSize && array[right] > array[maxValue]) {
            maxValue = right;
        }
        if (maxValue != root) {
            swap(array, maxValue, root);
            adjustHeap(array, maxValue, heapSize);
        }
    }

}
