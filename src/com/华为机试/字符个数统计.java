package com.华为机试;

import java.util.Scanner;

public class 字符个数统计 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] inputCount = in.nextLine().toCharArray();

        int[] numCount = new int[128];

        for (char c : inputCount) {
            numCount[(int)c] ++;
        }

        int allCount = 0;
        for (int count : numCount) {
            allCount += (count >= 1 ? 1:0);
        }

        System.out.println(allCount);
    }
}
