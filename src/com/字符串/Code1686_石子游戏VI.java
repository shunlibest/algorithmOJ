package com.字符串;

import java.util.Arrays;

public class Code1686_石子游戏VI {
    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        int[] b = {1, 6, 7};
        int i = new Code1686_石子游戏VI().stoneGameVI(a, b);
        System.out.println(i);
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[] score = new int[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            score[i] = aliceValues[i] + bobValues[i];
        }

        Integer[] ids = new Integer[aliceValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (i, j) -> aliceValues[j] + bobValues[j] - (aliceValues[i] + bobValues[i]));

        int sum = 0;
        for (int i = 0; i < score.length; i++) {
            if (i % 2 == 0) {
                sum += aliceValues[ids[i]];
            } else {
                sum -= bobValues[ids[i]];
            }
        }

        if (sum == 0) {
            return 0;
        } else {
            return sum / Math.abs(sum);
        }

    }
}
