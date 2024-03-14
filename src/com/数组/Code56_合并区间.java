package com.数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Code56_合并区间 {

    public static void main(String[] args) {
        int[][] array = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = new Code56_合并区间().merge(array);
        for (int[] arr : merge) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int[] currentMerged = new int[2];
        currentMerged[0] = intervals[0][0];
        currentMerged[1] = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        for (int[] arr : intervals) {
            if (arr[0] > currentMerged[1]) {
                list.add(currentMerged);
                currentMerged = new int[2];
                currentMerged[0] = arr[0];
                currentMerged[1] = arr[1];
            } else {
                currentMerged[1] = Math.max(currentMerged[1], arr[1]);
            }
        }
        list.add(currentMerged);
        return list.toArray(new int[list.size()][]);
    }
}
