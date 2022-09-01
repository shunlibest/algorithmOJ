package com.排序算法;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

import static com.排序算法.SortUtils.swap;

public class 冒泡排序 {

    public static void main(String[] args) {
//        int[] array = new int[]{9, 8, 5, 4, 20};
        int[] array = RandomUtil.randomInts(1000);
        sort(array);
    }


    private static void sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
        System.out.println(Arrays.toString(array));;
    }


}
