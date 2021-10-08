package com.竞赛;

public class 转换字符串的最少操作次数 {


    public static void main(String[] args) {
        int xxx = minimumMoves("XXOX");


        System.out.println(xxx);
    }

    public static int minimumMoves(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'X') {
                chars[i] = 'O';
                if (i + 1 < chars.length) {
                    chars[i + 1] = 'O';
                }
                if (i + 2 < chars.length) {
                    chars[i + 2] = 'O';
                }

                sum++;
            }
        }

        return sum;
    }

}
