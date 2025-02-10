package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-28 17:44:28
 * 题目名称: 找到最终的安全状态
 * 题目类型:
 * 思考:
 */


public class Code802_findEventualSafeStates {
    public static void main(String[] args) {
        Solution solution = new Code802_findEventualSafeStates().new Solution();
        int[][] i0 = Utils.convertStringTo2DArray("[[1,2],[2,3],[5],[0],[5],[],[]]");
        List<Integer> integers = solution.eventualSafeNodes(i0);
        Utils.printTable(integers);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> eventualSafeNodes(int[][] graph) {

            List<List<Integer>> edges = new ArrayList<>(graph.length);

            for (int i = 0; i < graph.length; i++) {
                edges.add(i, new ArrayList<>());
            }

            int[] inDegree = new int[graph.length];


            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[i].length; j++) {
                    edges.get(graph[i][j]).add(i);

                }

                inDegree[i] = graph[i].length;

            }


            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

//            Utils.printTable(inDegree);

            List<Integer> resultList = new ArrayList<>();

            while (!queue.isEmpty()) {
                int current = queue.poll();
                resultList.add(current);
                for (int nextNode : edges.get(current)) {
                    // 移除当前节点, 每个子儿子的入度数都会-1
                    inDegree[nextNode] = inDegree[nextNode] - 1;

                    // 如果等于0, 则代表此节点可以作为根节点继续遍历
                    if (inDegree[nextNode] == 0) {
                        queue.add(nextNode);
                    }
                }
            }

//            Utils.printDrawMap(edges);

//            Utils.printTable(inDegree);

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < inDegree.length; i++) {

                if (inDegree[i] ==0){
                    res.add(i);
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
