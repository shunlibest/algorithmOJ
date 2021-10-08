package com.回溯法;

import java.util.ArrayList;
import java.util.List;

public class Code39_组合总和 {

    public static void main(String[] args) {
        int[] input = new int[]{2, 3, 6, 7};

        List<List<Integer>> i = new Code39_组合总和().combinationSum(input, 7);
        System.out.println(i);
    }

    // 存放所有的结果
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        combinationSumHelper(0, target, new ArrayList<>());
        return result;
    }

    void combinationSumHelper(int startIndex, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSumHelper(i,target-candidates[i],list);
            list.remove((Integer) candidates[i]);
        }
    }

}
