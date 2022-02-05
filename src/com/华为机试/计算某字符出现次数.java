package com.华为机试;

import java.util.Scanner;

public class 计算某字符出现次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] inputString = in.nextLine().toLowerCase().toCharArray();
        char findC = in.next().toLowerCase().toCharArray()[0];

        int sum =0;
        for (char c : inputString) {
            if (c == findC){
                sum++;
            }
        }
        System.out.println(sum);


    }
}
