package com.华为机试;

import java.util.Scanner;

public class 句子逆序 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] inputStrings = in.nextLine().split(" ");


        for (int i = inputStrings.length-1; i >=0 ; i--) {
            System.out.print(inputStrings[i]+" ");
        }
    }
}
