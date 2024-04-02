package com.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code1431_拥有最多糖果的孩子 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        List<Boolean> booleans = new Code1431_拥有最多糖果的孩子().kidsWithCandies(candies, 3);

        for (Boolean b : booleans) {
            System.out.println(b + ",");
        }

    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies) {
            max = Math.max(max, i);
        }
        List<Boolean> list = new ArrayList<>(candies.length);
        for (int i : candies) {
            list.add(i + extraCandies >= max);
        }
        return list;
    }

}
