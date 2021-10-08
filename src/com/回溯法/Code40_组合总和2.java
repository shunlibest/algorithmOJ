package com.回溯法;

import java.util.*;

public class Code40_组合总和2 {

    public static void main(String[] args) {
        int[] input = new int[]{10, 1, 2, 7, 6, 1, 5};

        List<List<Integer>> i = new Code40_组合总和2().combinationSum(input, 8);
        System.out.println(i);
    }

    // 存放所有的结果
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        this.candidates = candidates;
        combinationSumHelper(0, target, new ArrayList<>());
        return result;
    }

    boolean combinationSumHelper(int startIndex, int target, List<Integer> list) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return true;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            list.add(candidates[i]);
            boolean b = combinationSumHelper(i + 1, target - candidates[i], list);
            list.remove((Integer) candidates[i]);
            if (b){
               break;
            }
        }

        return false;
    }

}
