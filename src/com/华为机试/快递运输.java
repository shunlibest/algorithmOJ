package com.华为机试;

import java.util.Arrays;
import java.util.Scanner;

public class 快递运输 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String[] boxString = in.nextLine().split(",");
        int[] boxWeight = new int[boxString.length];

        for (int i = 0; i < boxString.length; i++) {
            boxWeight[i] =  Integer.parseInt(boxString[i]);
        }

        Arrays.sort(boxWeight);
        int remain = in.nextInt();
        int count = 0;
        for (int weight : boxWeight) {
            remain -= weight;
            if (remain < 0){
                break;
            }else{
                count++;
            }
        }

        System.out.print(count);

    }
}
