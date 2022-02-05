package com.华为机试;

import java.util.Scanner;

public class 质数因子 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input = in.nextInt();

        int currentValue = input;
        do{
            int minPrimeNum = getMinPrimeNum(currentValue);
            currentValue = currentValue / minPrimeNum;
            System.out.println(minPrimeNum+" "+ currentValue);
//            System.out.print(minPrimeNum+" ");

        }while (currentValue !=1);


    }

    public static int getMinPrimeNum(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return i;
            }
        }

        return num;
    }
}