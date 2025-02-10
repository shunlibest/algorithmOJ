package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-28 12:00:14
 * 题目名称: 课程表
 * 题目类型:
 * 思考:
 */


public class Code207_courseSchedule {
    public static void main(String[] args) {
        Solution solution = new Code207_courseSchedule().new Solution();
        Object i0 = 2;
        Object i1 = 2;
        boolean b = solution.canFinish(2, Utils.convertStringTo2DArray("[[0,1]]"));
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            // 队列转边
            List<List<Integer>> edges = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) {
                edges.add(i, new ArrayList<>());
            }

            int[] inDegree = new int[numCourses];

            for (int[] connection : prerequisites) {
                edges.get(connection[1]).add(connection[0]);
                inDegree[connection[0]] = inDegree[connection[0]] + 1;
            }

//            Utils.printTable(inDegree);


            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int nextNode : edges.get(current)) {
                    // 移除当前节点, 每个子儿子的入度数都会-1
                    inDegree[nextNode] = inDegree[nextNode] - 1;

                    // 如果等于0, 则代表此节点可以作为根节点继续遍历
                    if (inDegree[nextNode] == 0) {
                        queue.add(nextNode);
                    }
                }
            }

//            Utils.printTable(inDegree);

            for (int i : inDegree) {
                if (i != 0){
                    return false;
                }
            }

            return true;

        }

        private void bfs(List<List<Integer>> edges) {
            Queue<Integer> queue = new ArrayDeque<>();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
