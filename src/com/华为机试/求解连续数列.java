package com.华为机试;

import java.util.Scanner;

public class 求解连续数列 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        int n = in.nextInt();

        int s1 = n * (n - 1) / 2;
        int s2 = sum - s1;

        if (s2 % n != 0) {
            System.out.print(-1);
            return;
        }

        int a1 = s2 / n;

        if(a1 <= 0){
            System.out.print(-1);
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(a1 + i);
            System.out.print(" ");
        }
    }
}
