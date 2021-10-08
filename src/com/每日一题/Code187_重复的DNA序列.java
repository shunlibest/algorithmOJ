package com.每日一题;

import java.util.*;

public class Code187_重复的DNA序列 {

    public static void main(String[] args) {
        List<String> repeatedDnaSequences = new Code187_重复的DNA序列().findRepeatedDnaSequences("AAAAAAAAAAA");

        System.out.println(Arrays.toString(repeatedDnaSequences.toArray()));

    }

    public List<String> findRepeatedDnaSequences(String s) {
        char[] chars = s.toCharArray();
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < chars.length - 9; i++) {
            String substring = s.substring(i, i + 10);
            Integer integer = hashMap.get(substring);
            int times = 0;
            if (integer != null) {
                times = integer;
            }
            hashMap.put(substring, times + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        hashMap.forEach((k, v) -> {
            if (v >= 2) {
                res.add(k);
            }
        });
        return res;
    }

}
