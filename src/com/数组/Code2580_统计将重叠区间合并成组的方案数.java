package com.数组;

import java.util.Arrays;
import java.util.Comparator;

public class Code2580_统计将重叠区间合并成组的方案数 {
    public static void main(String[] args) {
        int[][] array = {{0, 0}, {8, 9}, {12, 13}, {1, 3}};
        int i = new Code2580_统计将重叠区间合并成组的方案数().countWays(array);
        System.out.println(i);
    }

    public int countWays(int[][] ranges) {
        Integer[] index = new Integer[ranges.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, Comparator.comparingInt(o -> ranges[o][0]));
//        for (int i = 0; i < index.length; i++) {
//            System.out.println(Arrays.toString(ranges[index[i]]));
//        }

        int rangeCount = 1;
        int currentRangeEnd = ranges[index[0]][1];

        for (int i = 0; i < index.length; i++) {
            int start = ranges[index[i]][0];
            int end = ranges[index[i]][1];


            if (start > currentRangeEnd) {
                // 新的一组
                rangeCount++;
                currentRangeEnd = end;

            } else {
                currentRangeEnd = Math.max(currentRangeEnd, end);
            }


        }
        int res = 1;
        final int MOD = 1000000007;

        for (int i = 0; i < rangeCount; i++) {
            res = res * 2 % MOD;
        }


        return res;

    }
}
