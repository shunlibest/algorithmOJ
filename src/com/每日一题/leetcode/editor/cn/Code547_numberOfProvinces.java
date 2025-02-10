package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [每日一题] 2024-08-13 15:46:21
 * 题目名称: 省份数量
 * 题目类型:
 * 思考:
 */


public class Code547_numberOfProvinces {
    public static void main(String[] args) {
        Solution solution = new Code547_numberOfProvinces().new Solution();
        int[][] i0 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = solution.findCircleNum(i0);

        System.out.println(circleNum);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int N = isConnected.length;
            // 标记是否被访问过
            boolean[] visited = new boolean[N];

            // 要遍历的队列
            Queue<Integer> queue = new LinkedList<>();

            int count = 0;
            while (true) {
                // 找到起始点
                Integer startVert = findStartVert(isConnected, visited);
                if (startVert != null) {
                    queue.add(startVert);
                } else {
                    // 找不到未遍历的起始点了, 结束
                    break;
                }

                count++;
                // 开始从 要遍历的队列中 遍历第一位
                while (!queue.isEmpty()) {
                    // 取出第一个元素, 开始进行遍历
                    int needVisitVert = queue.poll();
                    // 这里做一些事情....
//                    System.out.println("开始遍历:" + needVisitVert);
                    // 遍历完成,
                    visited[needVisitVert] = true;

                    // 接下来把子元素也进行遍历
                    for (int i = 0; i < N; i++) {
                        // 不连通, 也无需进行遍历
                        if (isConnected[needVisitVert][i] != 1) {
                            continue;
                        }

                        // 子元素已经遍历过了
                        if (visited[i]) {
                            continue;
                        }
                        queue.add(i);
                    }
                }

            }


//            Utils.printTable(isConnected);
//            Utils.printTable(visited);


            return count;
        }

        private Integer findStartVert(int[][] isConnected, boolean[] visited) {
            int N = isConnected.length;
            // 找到起始点
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    // 满足起始条件
                    if (isConnected[i][j] == 1) {
                        return i;
                    }
                }
            }
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
