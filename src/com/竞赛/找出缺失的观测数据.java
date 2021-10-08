package com.竞赛;

public class 找出缺失的观测数据 {


    public static void main(String[] args) {

        int[] row = new int[]{3, 2, 4, 3};

        int[] xxx = missingRolls(row, 4, 2);


//        System.out.println(xxx);
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int value : rolls) {
            sum += value;
        }

        int[] res = new int[n];


        int allValue = mean * (n + rolls.length);

        return new int[]{};
    }

}
