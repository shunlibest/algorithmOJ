package com.排序算法;

//import cn.hutool.core.util.RandomUtil;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

import static com.排序算法.SortUtils.swap;

public class 选择排序 {

    public static void main(String[] args) {
//        int[] array = new int[]{9, 8, 5, 4, 20};
        int[] array = RandomUtil.randomInts(1000);

        System.out.println();
        sort(array);

        System.out.println(Arrays.toString(array));
    }


    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,minIndex,i);
        }
    }


}
