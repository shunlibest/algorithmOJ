package com.二叉树.堆;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Code_LCP30_魔塔游戏 {
    public static void main(String[] args) {
        int[] array = new int[]{100000, 100000, 100000, 100000, 100000, 100000, 100000,
                -100000, -100000, -100000, -100000, -100000, -100000, -100000};
        int i = new Code_LCP30_魔塔游戏().magicTower(array);
        System.out.println(i);
    }


    public int magicTower(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum < 0) {
            return -1;
        }

        long heath = 0;
        int count = 0;
        for (int n : nums) {
            if (n < 0) {
                maxHeap.add(n);
            }
            heath += n;
            if (heath < 0) {
                int peek = maxHeap.poll();
                heath -= peek;
                count++;
            }
        }
        return count;
    }


}
