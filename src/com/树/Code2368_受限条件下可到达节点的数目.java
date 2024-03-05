package com.树;

import java.util.ArrayList;
import java.util.List;

public class Code2368_受限条件下可到达节点的数目 {

    public static void main(String[] args) {
        int[][] array = {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}};
        int[] restricted = {4, 5};
        int i = new Code2368_受限条件下可到达节点的数目().reachableNodes(7, array, restricted);
        System.out.println(i);
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] restrictedArray = new boolean[n];
        for (int x : restricted) {
            restrictedArray[x] = true;
        }

        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }
        return dfs(tree, restrictedArray, 0, -1);
    }

    private int dfs(List<Integer>[] tree, boolean[] restrictedArray, int currentIndex, int parentIndex) {
//        printIndent(count++);
//        System.out.println("currentIndex:" + currentIndex);
        int childCount = 1;
        for (int child : tree[currentIndex]) {
            if (child == parentIndex) {
                continue;
            }
            if (restrictedArray[child]) {
                continue;
            }
            childCount += dfs(tree, restrictedArray, child, currentIndex);
        }
//        printIndent(--count);
//        System.out.println("return:" + childCount);
        return childCount;
    }


    int count = 0;

    private void printIndent(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" | ");
        }
    }


}
