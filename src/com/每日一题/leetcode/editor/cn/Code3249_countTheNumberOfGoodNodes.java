package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [每日一题] 2024-11-14 11:42:46
 * 题目名称: 统计好节点的数目
 * 题目类型:
 * 思考:
 */


public class Code3249_countTheNumberOfGoodNodes {
    public static void main(String[] args) {
        Solution solution = new Code3249_countTheNumberOfGoodNodes().new Solution();
        int[][] i0 = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
//        Object i1 = {{0,1},{1,2},{1,3},{1,4},{0,5},{5,6},{6,7},{7,8},{0,9},{9,10},{9,12},{10,11}};
        int i = solution.countGoodNodes(Utils.convertStringTo2DArray("[[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]"));

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countGoodNodes(int[][] edges) {

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int[] edge : edges) {
                List<Integer> children1 = map.computeIfAbsent(edge[0], k -> new ArrayList<>());
                children1.add(edge[1]);

                List<Integer> children2 = map.computeIfAbsent(edge[1], k -> new ArrayList<>());
                children2.add(edge[0]);
            }

            boolean[] visited = new boolean[map.size()];
            boolean[] isGood = new boolean[map.size()];

            getNodeCount(map, 0, visited, isGood);

//            Utils.printTable(visited);
//            Utils.printTable(isGood);
            int count = 0;
            for (boolean good : isGood) {
                if (good) {
                    count++;
                }
            }

            return count;
        }

        private int getNodeCount(Map<Integer, List<Integer>> map, int currentNode, boolean[] visited, boolean[] isGood) {
            visited[currentNode] = true;
            List<Integer> currentChildren = map.get(currentNode);

            int goodChildCount = -1;
            boolean isGoodNode = true;
            int allChildrenCount = 0;
            for (Integer currentChild : currentChildren) {
                if (visited[currentChild]) {
                    // 父节点, 不用遍历
                    continue;
                }
                int nodeCount = getNodeCount(map, currentChild, visited, isGood);
                if (goodChildCount == -1) {
                    goodChildCount = nodeCount;
                } else {
                    isGoodNode = isGoodNode && goodChildCount == nodeCount;
                }
                allChildrenCount += nodeCount;
            }
            isGood[currentNode] = isGoodNode;
            return allChildrenCount + 1;
        }

        public class Node {
            int val;

            List<Node> children;

            public Node(int val, List<Node> children) {
                this.val = val;
                this.children = children;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
