package com.华为机试;

import java.util.Scanner;

public class 取近似值 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        float input = in.nextFloat();
        System.out.println((int)(input+0.5f));

    }
}
