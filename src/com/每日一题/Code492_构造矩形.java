package com.每日一题;

import java.util.Arrays;
import java.util.List;

public class Code492_构造矩形 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        int[] res = new Code492_构造矩形().constructRectangle(11);

        System.out.println(Arrays.toString(res));

    }

    public int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        for (int i = sqrt; i >= 0; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }

        return new int[]{0, 0};
    }
}
