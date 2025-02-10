package com.每日一题.leetcode.editor.cn;

import com.Main;
import com.Utils;

import java.util.*;

/**
 * [每日一题] 2024-08-13 16:20:57
 * 题目名称: 寻找图中是否存在路径
 * 题目类型:
 * 思考:
 */


public class Code1971_findIfPathExistsInGraph {
    public static void main(String[] args) {
        Solution solution = new Code1971_findIfPathExistsInGraph().new Solution();
        Object i0 = 3;
        Object i1 = 0;
        Object i2 = 6;
        Object i3 = 0;
        boolean b = solution.validPath(10, Utils.convertStringTo2DArray("[[0,7],[0,8],[6,1],[2,0],[0,4],[5,8],[4,7],[1,3],[3,5],[6,5]]"), 7, 5);
        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPath(int n, int[][] edges, int source, int destination) {

            // 预处理
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] edge : edges) {
                Set<Integer> set0 = map.getOrDefault(edge[0], new HashSet<>());
                set0.add(edge[1]);
                map.put(edge[0], set0);

                Set<Integer> set1 = map.getOrDefault(edge[1], new HashSet<>());
                set1.add(edge[0]);
                map.put(edge[1], set1);
            }


            boolean[] visited = new boolean[n];

            // 要遍历的队列
            Queue<Integer> queue = new LinkedList<>();

            // 找起始点
//            int start = source;
            queue.add(source);
            visited[source] = true;

            // 开始遍历(遍历队列)

            while (!queue.isEmpty()) {
                // 遍历第一个
                int currentVert = queue.poll();
                // ....做点事情
//                System.out.println("遍历:" + currentVert);
                if (currentVert == destination) {
                    // 找到了需要的元素
                    return true;
                }
                // 做完了

                // 开始遍历子元素(下一个元素)
                Set<Integer> set = map.get(currentVert);

                for (int next : set) {
                    if (!visited[next]) {
                        // 满足条件, 遍历子元素
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }

            return false;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
