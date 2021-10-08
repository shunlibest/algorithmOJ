package com.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Code77_组合 {

    public static void main(String[] args) {

//        String[] strs = new String[]{"dog", "racecar", "car"};


        List<List<Integer>> i = new Code77_组合().combine(4, 2);
        System.out.println(i);
    }

    //首先需要两个变量，一个用来存放所有的结果
    List<List<Integer>> result = new ArrayList<>();
//    //一个用来存放当前到叶节点的结果
//    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1, new ArrayList<>());
        return result;
    }


    private void combineHelper(int n, int k, int startIndex, List<Integer> list) {
        //终止条件
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            list.add(i);
            combineHelper(n, k-1, i + 1, list);
            //这里最后还要恢复原状，以便进行下一个兄弟节点的遍历
            list.remove((Integer) i);
        }
    }
}
