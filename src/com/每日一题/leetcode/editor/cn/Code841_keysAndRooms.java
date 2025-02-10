package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.List;

/**
 * [每日一题] 2024-08-26 10:42:20
 * 题目名称: 钥匙和房间
 * 题目类型:
 * 思考:
 */


public class Code841_keysAndRooms {
    public static void main(String[] args) {
        Solution solution = new Code841_keysAndRooms().new Solution();
        boolean b = solution.canVisitAllRooms(Utils.convertStringToList("[[1,3],[3,0,1],[2],[0]]"));

        System.out.println(b);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            // 深度优先遍历

            boolean[] visited = new boolean[rooms.size()];
            visited[0] = true;

            // 当前遍历的列表, 防止往回遍历
            boolean[] visitedList = new boolean[rooms.size()];

            visitedList[0] = true;
            dfs(rooms, rooms.get(0), visited);

//            Utils.printTable(visited);

            for (boolean visit : visited) {
                if (!visit) {
                    return false;
                }
            }

            return true;
        }


        // 当前节点
        private void dfs(List<List<Integer>> rooms, List<Integer> currentRoom, boolean[] visited) {
            // 终结条件
            for (Integer nextRoom : currentRoom) {
                if (visited[nextRoom]) {
                    continue;
                }
                visited[nextRoom] = true;
                dfs(rooms, rooms.get(nextRoom), visited);
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
