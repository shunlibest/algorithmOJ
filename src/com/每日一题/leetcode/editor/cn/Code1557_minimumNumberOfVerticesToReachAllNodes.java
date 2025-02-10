package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-28 10:16:42
 * 题目名称: 可以到达所有点的最少点数目
 * 题目类型:
 * 思考:
 */


public class Code1557_minimumNumberOfVerticesToReachAllNodes {
    public static void main(String[] args) {
        Solution solution = new Code1557_minimumNumberOfVerticesToReachAllNodes().new Solution();
        Object i0 = 6;
        Object i1 = 5;
        List<Integer> smallestSetOfVertices = solution.findSmallestSetOfVertices(6, Utils.convertStringToList("[[0,1],[0,2],[2,5],[3,4],[4,2]]"));

        Utils.printTable(smallestSetOfVertices);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            // 队列转边
            boolean[] hasParent = new boolean[n];


            for (int i = 0; i < edges.size(); i++) {
                List<Integer> edge = edges.get(i);
                hasParent[edge.get(1)] = true;
            }


            List<Integer> res = new ArrayList<>();

            for (int i = 0; i < hasParent.length; i++) {
                if (!hasParent[i]){
                    res.add(i);
                }
            }



            return res;

        }

//        public int getRoot(List<List<Integer>> edges, int currentNode) {
//
//            while (edges.get(currentNode) == null) {
//                currentNode = edges.get(currentNode);
//            }
//        }


        public void bfs(List<List<Integer>> edges, boolean[] visited, int currentNode) {

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(currentNode);

            visited[currentNode] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (Integer nextNode : edges.get(current)) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
