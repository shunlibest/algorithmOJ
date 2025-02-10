package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [每日一题] 2024-08-27 10:09:32
 * 题目名称: 获取你好友已观看的视频
 * 题目类型:
 * 思考:
 */


public class Code1311_getWatchedVideosByYourFriends {
    public static void main(String[] args) {
        Solution solution = new Code1311_getWatchedVideosByYourFriends().new Solution();
        List<List<String>> watchedVideos = Utils.convertStringToStringList("[[\"bjwtssmu\"],[\"aygr\",\"mqls\"],[\"vrtxa\",\"zxqzeqy\",\"nbpl\",\"qnpl\"],[\"r\",\"otazhu\",\"rsf\"],[\"bvcca\",\"ayyihidz\",\"ljc\",\"fiq\",\"viu\"]]");
        int[][] friends = Utils.convertStringTo2DArray("[[3,2,1,4],[0,4],[4,0],[0,4],[2,3,1,0]]");
//        Object i1 = 0;
//        Object i2 = {{"A","B"},{"C"},{"B","C"},{"D"}};
//        Object i3 = 0;
        List<String> strings = solution.watchedVideosByFriends(watchedVideos, friends, 3, 1);

        Utils.printDrawMap("[[3,2,1,4],[0,4],[4,0],[0,4],[2,3,1,0]]");

        Utils.printTable(strings);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

            //BFS

            Set<Integer> bfs = bfs(friends, id, level);

//            System.out.println(bfs);
            Map<String, Integer> map = new HashMap<>();

            for (int levelNode : bfs) {
                List<String> watches = watchedVideos.get(levelNode);

                for (String watch : watches) {
                    int count = map.getOrDefault(watch, 0);
                    map.put(watch, count + 1);
                }
            }


            List<String> result = new ArrayList<>(map.keySet());


            Collections.sort(result, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (map.get(o1).intValue() == map.get(o2).intValue()) {
                        return o1.compareTo(o2);
                    }


                    return Integer.compare(map.get(o1), map.get(o2));
                }
            });

//            map.ke

//            for (int i = 0; i < map.entrySet().size(); i++) {
//                map.entrySet().
//            }
//


//            List<Integer> collect = map.values().stream().sorted().collect(Collectors.toList());
//            Utils.printTable(collect);
//

            return result;
        }

        private Set<Integer> bfs(int[][] friends, int id, int level) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(id);

            boolean[] visited = new boolean[friends.length];
            visited[id] = true;

            int[] deep = new int[friends.length];
            deep[0] = 0;

            Set<Integer> levelSet = new HashSet<>();

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                int currentNodeDeep = deep[currentNode];
                if (currentNodeDeep == level) {
                    levelSet.add(currentNode);
                } else if (currentNodeDeep > level) {
                    break;
                }


                for (int nextNode : friends[currentNode]) {
                    if (visited[nextNode]) {
                        continue;
                    }
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    deep[nextNode] = currentNodeDeep + 1;
                }
            }

//            Utils.printTable(deep);

            return levelSet;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
