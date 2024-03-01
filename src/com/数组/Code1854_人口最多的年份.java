package com.数组;

public class Code1854_人口最多的年份 {

    public static void main(String[] args) {
        int[][] logs = {{2012, 2014}, {2032, 2038}, {1989, 2035}, {1979, 1981}, {2010, 2013}, {1971, 2036}, {2024, 2037}, {2028, 2047}};


        int i = new Code1854_人口最多的年份().maximumPopulation(logs);
        System.out.println(i);
    }


    public int maximumPopulation(int[][] logs) {
        int count = 0;
        int maxCount = 0;
        int maxYear = 0;
        for (int i = 1950; i <= 2050; i++) {
            for (int j = 0; j < logs.length; j++) {
                if (i == logs[j][0]) {
                    count++;
                }

                if (i == logs[j][1]) {
                    count--;
                }
            }
            if (count > maxCount) {
                maxYear = i;
                maxCount = count;
            }
        }
        return maxYear;
    }

    public int maximumPopulation2(int[][] logs) {
        final int MIN = 1950;
        final int MAX = 2050;
        int[] yearRecord = new int[MAX - MIN];
        for (int i = 0; i < logs.length; i++) {
            yearRecord[logs[i][0] - MIN]++;
            yearRecord[logs[i][1] - MIN]--;
        }
        int maxYear = 0;
        int maxNum = 0;
        int num = 0;
        for (int i = 0; i < yearRecord.length; i++) {
            num += yearRecord[i];
            if (num > maxNum) {
                maxYear = i + MIN;
                maxNum = num;
            }
        }

        return maxYear;
    }
}
