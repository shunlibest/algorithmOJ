package com.排序算法;

import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

import static com.排序算法.SortUtils.swap;

public class 插入排序 {

    public static void main(String[] args) {
//        int[] array = new int[]{9, 8, 5, 4, 20};
        int[] array = RandomUtil.randomInts(1000);
        sort(array);
        System.out.println(Arrays.toString(array));;

    }


    private static void sort(int[] array) {
        for (int i = 1; i < array.length -1; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
        }
    }


}
