package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [每日一题] 2024-08-27 16:27:28
 * 题目名称: 你能从盒子里获得的最大糖果数
 * 题目类型:
 * 思考:
 */


public class Code1298_maximumCandiesYouCanGetFromBoxes {
    public static void main(String[] args) {
        Solution solution = new Code1298_maximumCandiesYouCanGetFromBoxes().new Solution();
//        Object i0 = {1,0,1,0};
//        Object i1 = {{},{},{1},{}};
//        Object i2 = {0};
//        Object i3 = {1,1,1,1,1,1};
//        Object i4 = {{1,2,3,4,5},{},{},{},{},{}};


        int[] status = {1, 0, 1, 0};
        int[] candies = {7, 5, 4, 100};
        int[][] keys = Utils.convertStringTo2DArray("[[],[],[1],[]]");
        int[][] containedBoxes = Utils.convertStringTo2DArray("[[1,2],[3],[],[]]");
        int[] initialBoxes = {0};


        int i = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {


            Queue<Integer> queue = new ArrayDeque<>();

            // 1: 只有钥匙
            boolean[] keyList = new boolean[status.length];
            // 2: 只有盒子
            boolean[] boxList = new boolean[status.length];

            // 3: 已经访问过了
            boolean[] visited = new boolean[status.length];

            // 添加初始化可以开启的盒子
            for (int initialBox : initialBoxes) {
                boxList[initialBox] = true;
                if (status[initialBox] == 1) {
                    queue.add(initialBox);
                    visited[initialBox] = true;
                }
            }

            for (int i = 0; i < status.length; i++) {
                if (status[i] == 1) {
                    keyList[i] = true;
                }
            }


            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int key : keys[currentNode]) {
                    keyList[key] = true;
                }
                for (int box : containedBoxes[currentNode]) {
                    boxList[box] = true;
                }

                for (int key : keys[currentNode]) {
                    if (visited[key]) {
                        continue;
                    }
                    if (keyList[key] && boxList[key]) {
                        visited[key] = true;
                        queue.add(key);
                    }
                }

                for (int box : containedBoxes[currentNode]) {
                    if (visited[box]) {
                        continue;
                    }
                    if (keyList[box] && boxList[box]) {
                        visited[box] = true;
                        queue.add(box);
                    }
                }

            }

//            Utils.printTable(visited);

            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]){
                    sum += candies[i];
                }
            }

            return sum;
        }


        private void dfs() {

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
