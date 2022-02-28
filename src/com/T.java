package com;

import java.util.ArrayList;
import java.util.HashMap;

public class T {


    public static void main(String[] args) {
        char[] c1 = "ab".toCharArray();
        char[] c2 = "ab".toCharArray();
        boolean solution = solution(c1, c2);
        System.out.println(solution);
    }

    public static boolean solution(char[] char1, char[] char2) {
        if (char1.length != char2.length) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < char1.length; i++) {
            if (char1[i] != char2[i]) {
                int s = char1[i] - char2[i]; // a b =  -1  b a = 1 c d =1
                list.add(s);
            }
        }
        // aab aab
        HashMap<Integer,Integer> h = new HashMap<>();
        if (list.size() == 0){


            return true;
        }

        if (list.size() != 2) {
            return false;
        }
        return list.get(0) + list.get(1) == 0;
    }




}
