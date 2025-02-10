package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [每日一题] 2024-08-26 15:18:38
 * 题目名称: 有向无环图中一个节点的所有祖先
 * 题目类型:
 * 思考:
 */


public class Code2192_allAncestorsOfANodeInADirectedAcyclicGraph {
    public static void main(String[] args) {
        Solution solution = new Code2192_allAncestorsOfANodeInADirectedAcyclicGraph().new Solution();
        Object i0 = 8;
        Object i1 = 5;
        List<List<Integer>> ancestors = solution.getAncestors(8, Utils.convertStringTo2DArray("[[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]"));

        System.out.println(ancestors);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<List<Integer>> getAncestors(int n, int[][] edges) {
            // 队列转边
            List<List<Integer>> edgeList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                edgeList.add(i, new ArrayList<>());
            }
            for (int[] connection : edges) {
                edgeList.get(connection[1]).add(connection[0]);
            }

            // 存储当前节点的父节点
            List<Set<Integer>> result = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                result.add(i, new HashSet<>());
            }

            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(edgeList, i, visited, result);
            }

            for (int i = 0; i < n; i++) {
                result.get(i).remove(i);
            }

            List<List<Integer>> resultSorted = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                resultSorted.add(i, result.get(i).stream().sorted().collect(Collectors.toList()));
            }

            return resultSorted;

        }

        private void dfs(List<List<Integer>> edges, int currentNode, boolean[] visited, List<Set<Integer>> result) {

            result.get(currentNode).add(currentNode);


            for (int nextNode : edges.get(currentNode)) {
                if (visited[nextNode]) {
                    result.get(currentNode).addAll(result.get(nextNode));
                    continue;
                }

                visited[nextNode] = true;

                dfs(edges, nextNode, visited, result);
                result.get(currentNode).addAll(result.get(nextNode));
            }
        }
//        public List<List<Integer>> getAncestors(int n, int[][] edges) {
//
//            // 队列转边
//            List<List<Integer>> edgeList = new ArrayList<>(n);
//            for (int i = 0; i < n; i++) {
//                edgeList.add(i, new ArrayList<>());
//            }
//
//            List<Set<Integer>> result = new ArrayList<>(n);
//            for (int i = 0; i < n; i++) {
//                result.add(i, new HashSet<>());
//            }
//
//            Set<Integer> hasParentNode = new HashSet<>();
//            for (int[] connection : edges) {
//                edgeList.get(connection[0]).add(connection[1]);
//
//                hasParentNode.add(connection[1]);
//            }
//
//            for (int i = 0; i < n; i++) {
//                if (hasParentNode.contains(i)) {
//                    continue;
//                }
//
//                Set<Integer> currentVisitedSet = new HashSet<>();
//                currentVisitedSet.add(i);
//                dfs(edgeList, i, currentVisitedSet, result);
//
//                result.get(i).clear();
//            }
//
//            List<List<Integer>> resultSorted = new ArrayList<>(n);
//
//            for (int i = 0; i < n; i++) {
//                resultSorted.add(i, result.get(i).stream().sorted().collect(Collectors.toList()));
//            }
//
//
//            return resultSorted;
//
//        }
//
//        private void dfs(List<List<Integer>> edges, int currentNode, Set<Integer> currentVisitedSet, List<Set<Integer>> result) {
//            result.get(currentNode).addAll(currentVisitedSet);
//            for (int nextNode : edges.get(currentNode)) {
//                if (currentVisitedSet.contains(nextNode)) {
//                    continue;
//                }
//                currentVisitedSet.add(currentNode);
//                dfs(edges, nextNode, currentVisitedSet, result);
//                currentVisitedSet.remove(currentNode);
//
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
