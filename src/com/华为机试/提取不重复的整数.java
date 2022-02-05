package com.华为机试;

import java.util.Scanner;

public class 提取不重复的整数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] input = (in.nextInt() + "").toCharArray();

        int[] countNum = new int[10];
        for (int i = input.length - 1; i >= 0; i--) {

            int c = input[i] - 48;

            if (countNum[c] ==0){
                System.out.print(input[i]+" ");
                countNum[c] = 1;
            }
        }

    }
}
