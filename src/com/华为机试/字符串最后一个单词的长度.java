package com.华为机试;

import java.util.Scanner;

public class 字符串最后一个单词的长度 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { //注意while处理多个case  int a = in.nextInt();
            String input = in.nextLine();
            String[] words = input.split(" ");

            String finalWord = words[words.length - 1];

            System.out.println(finalWord.length());

        }
    }
}
