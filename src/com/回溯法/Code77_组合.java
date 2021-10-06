package com.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code77_组合 {

    public static void main(String[] args) {

//        String[] strs = new String[]{"dog", "racecar", "car"};
        String[] strs = new String[]{"ab", "ab", "a"};

        List<List<Integer>> i = new Code77_组合().combine(1, 2);
        System.out.println(i);
    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1, new ArrayList<>());
        return result;
    }


    private void combineHelper(int n, int k, int startIndex, List<Integer> list) {
        //终止条件
        if (k == startIndex) {
            return;
        }

//        for (int i = startIndex; i <; i++) {
//
//        }

    }
}
