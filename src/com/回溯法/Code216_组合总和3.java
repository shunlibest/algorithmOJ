package com.回溯法;

import java.util.*;

public class Code216_组合总和3 {

    public static void main(String[] args) {

//        String[] strs = new String[]{"dog", "racecar", "car"};


        List<List<Integer>> i = new Code216_组合总和3().combinationSum3(3, 9);
        System.out.println(i);
    }

    //首先需要两个变量，一个用来存放所有的结果
    List<List<Integer>> result = new ArrayList<>();

    int allSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        allSum = n;

        combinationSum3Helper(k, 1, new LinkedList<>());
        return result;
    }

    void combinationSum3Helper(int k, int startNum, List<Integer> set) {
        if (k == 0) {
            int sum = 0;
            for (Integer value : set) {
                sum += value;
            }
            if (sum == allSum) {
                result.add(new ArrayList<>(set));
            }
            return;
        }

        for (int i = startNum; i <= 9; i++) {
            set.add(i);
            combinationSum3Helper(k-1,i+1,set);
            set.remove((Integer) i);
        }
    }
}
