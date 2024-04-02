package com.数组;

public class Code605_种花问题 {
    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 0, 1};
        boolean b = new Code605_种花问题().canPlaceFlowers(flowerbed, 2);
        System.out.println(b);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0
                    && getOrDefault(flowerbed, i - 1, 0) == 0
                    && getOrDefault(flowerbed, i + 1, 0) == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    private int getOrDefault(int[] array, int index, int defaultValue) {
        if (index < 0 || index > array.length - 1) {
            return defaultValue;
        }
        return array[index];
    }
}
