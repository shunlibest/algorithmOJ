package com.每日一题;

import java.util.Arrays;

public class Code66_加一 {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        int[] res = new Code66_加一().plusOne(input);

        System.out.println(Arrays.toString(res));

    }

    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length+1];
        int addOne = 1;
        for (int i = digits.length-1 ; i >=0 ; i--) {
            if (digits[i]+addOne >=10){
                digits[i] = 0;
            }else {
                digits[i] =digits[i] +1;
                break;
            }
        }
        if (digits[0]==0){
            res[0]=1;
            return res;
        }
        return digits;
    }
}
