package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * [每日一题] 2024-08-28 16:53:19
 * 题目名称: 课程表 II
 * 题目类型:
 * 思考:
 */


public class Code210_courseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new Code210_courseScheduleIi().new Solution();
        Object i0 = 2;
        Object i1 = 4;
        Object i2 = 1;
        int[] b = solution.findOrder(3, Utils.convertStringTo2DArray("[[1,0],[1,2],[0,1]]"));

        Utils.printTable(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
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

//            Utils.printDrawMap(edges);

//            Utils.printTable(inDegree);


            Queue<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

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

            if (resultList.size() != numCourses){
                return  new int[0];
            }

//            Utils.printTable(inDegree);

            int[] res = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                res[i] = resultList.get(i);
            }



            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
