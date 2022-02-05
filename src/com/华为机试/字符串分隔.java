package com.华为机试;

import java.util.Scanner;

public class 字符串分隔 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) { //注意while处理多个case  int a = in.nextInt();
            char[] inputString = in.nextLine().toCharArray();


            int ceilNum = (inputString.length / 8 + (inputString.length % 8 == 0 ? 0 : 1)) * 8;
            for (int i = 0; i < ceilNum; i++) {
                if (i % 8 == 0 && i != 0) {
                    System.out.println();
                }
                if (i >= inputString.length) {
                    System.out.print('0');
                } else {
                    System.out.print(inputString[i]);
                }
            }
            System.out.println();

        }
    }
}
