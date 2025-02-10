package com.每日一题.leetcode.editor.cn;

import cn.hutool.core.io.FileUtil;
import com.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * [每日一题] 2024-08-26 11:14:22
 * 题目名称: 统计无向图中无法互相到达点对数
 * 题目类型:
 * 思考:
 */


public class Code2316_countUnreachablePairsOfNodesInAnUndirectedGraph {
    public static void main(String[] args) {
        Solution solution = new Code2316_countUnreachablePairsOfNodesInAnUndirectedGraph().new Solution();
        Object i0 = 3;
        Object i1 = 7;

        String s = FileUtil.readUtf8String("/Users/shunlihan/Downloads/test.txt");

//        long l = solution.countPairs(100000, Utils.convertStringTo2DArray(s));
        long l = solution.countPairs(7, Utils.convertStringTo2DArray("[[0,2],[0,5],[2,4],[1,6],[5,4]]"));
        System.out.println(l);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countPairs(int n, int[][] edges) {

            List<Set<Integer>> list = new ArrayList<>(edges.length);
            for (int i = 0; i < n; i++) {
                list.add(i, new HashSet<>());
            }

            long start = System.currentTimeMillis();
            for (int[] edge : edges) {
                list.get(edge[0]).add(edge[1]);
                list.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[n];

            List<Integer> independentList = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                int count = dfs(i, list, visited);

                independentList.add(count);
            }

//            System.out.println(independentList);

            long sum = 0;
            for (Integer integer : independentList) {
                sum += (long) integer * (n - integer);
            }

            return sum / 2;
        }


        private int dfs(int currentNode, List<Set<Integer>> edges, boolean[] visited) {
            //currentNode 当前要遍历的节点
//            if (edges.get(currentNode).isEmpty()) {
//                return 1;
//            }


            int sum = 1;
            for (Integer nextNode : edges.get(currentNode)) {
                if (visited[nextNode]) {
                    continue;
                }
                visited[nextNode] = true;
                sum += dfs(nextNode, edges, visited);
            }

            return sum;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
