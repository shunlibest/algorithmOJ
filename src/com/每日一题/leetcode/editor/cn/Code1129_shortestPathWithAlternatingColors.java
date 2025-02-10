package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.*;

/**
 * [每日一题] 2024-08-27 14:58:45
 * 题目名称: 颜色交替的最短路径
 * 题目类型:
 * 思考:
 */


public class Code1129_shortestPathWithAlternatingColors {
    public static void main(String[] args) {
        Solution solution = new Code1129_shortestPathWithAlternatingColors().new Solution();
//        Object i0 = 3;
//        Object i1 = {};
//        Object i2 = {{0,1}};
        int[][] redEdges = Utils.convertStringTo2DArray("[[3,2],[4,1],[1,4],[2,4]]");
        int[][] blueEdges = Utils.convertStringTo2DArray("[[2,3],[0,4],[4,3],[4,4],[4,0],[1,0]]");
        int[] ints = solution.shortestAlternatingPaths(5, redEdges, blueEdges);


        Utils.printTable(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

            // 队列转边
            List<List<Integer>> redEdgesList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                redEdgesList.add(i, new ArrayList<>());
            }
            for (int[] connection : redEdges) {
                redEdgesList.get(connection[0]).add(connection[1]);
            }


            List<List<Integer>> blueEdgesList = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                blueEdgesList.add(i, new ArrayList<>());
            }
            for (int[] connection : blueEdges) {
                blueEdgesList.get(connection[0]).add(connection[1]);
            }

//            Utils.printDrawMap(redEdgesList);
//            Utils.printDrawMap(blueEdgesList);

            int[] bfs = bfs(redEdgesList, blueEdgesList);
            int[] bfs2 = bfs(blueEdgesList, redEdgesList);

            for (int i = 0; i < bfs.length; i++) {
                bfs[i] = Math.min(bfs[i], bfs2[i]);

                if (bfs[i] == Integer.MAX_VALUE) {
                    bfs[i] = -1;
                }
            }


            return bfs;
        }


        private int[] bfs(List<List<Integer>> redEdgesList, List<List<Integer>> blueEdgesList) {
            Queue<Data> queue = new ArrayDeque<>();

            queue.add(new Data(0, 0));

            boolean[] redVisited = new boolean[redEdgesList.size()];
            boolean[] blueVisited = new boolean[redEdgesList.size()];
            int[] minStep = new int[redEdgesList.size()];
            Arrays.fill(minStep, Integer.MAX_VALUE);

            minStep[0] = 0;
            redVisited[0] = true;

            while (!queue.isEmpty()) {
                Data currentNode = queue.poll();

//                System.out.println("访问:" + currentNode.node);


                List<Integer> canArrive;
                // 先走红色节点
                if (currentNode.deep % 2 == 0) {
                    canArrive = redEdgesList.get(currentNode.node);
                } else {
                    canArrive = blueEdgesList.get(currentNode.node);
                }

                for (int nextNode : canArrive) {
                    if (currentNode.deep % 2 == 0) {
                        if (blueVisited[nextNode]) {
                            continue;
                        }
                        blueVisited[nextNode] = true;
                    } else {
                        if (redVisited[nextNode]) {
                            continue;
                        }
                        redVisited[nextNode] = true;
                    }

                    if (minStep[nextNode] == Integer.MAX_VALUE) {
                        minStep[nextNode] = currentNode.deep + 1;
                    }

                    queue.add(new Data(nextNode, currentNode.deep + 1));
                }
            }
            return minStep;
        }


        public class Data {
            public int node;
            public int deep;

            public Data(int node, int deep) {
                this.node = node;
                this.deep = deep;
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
