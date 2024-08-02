package com.每日一题.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

/**
 * [每日一题] 2024-07-24 10:55:18
 * 题目名称: 重新放置石块
 * 题目类型:
 * 思考:
 */
public class Code2766_relocateMarbles {
    public static void main(String[] args) {
        Solution solution = new Code2766_relocateMarbles().new Solution();
        int[] nums = {1,6,7,8}, moveFrom = {1,7,2}, moveTo = {2,9,5};
        List<Integer> integers = solution.relocateMarbles(nums, moveFrom, moveTo);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {

            Set<Integer> positionSets = new HashSet<>();

            for (int num : nums) {
                positionSets.add(num);
            }

            for (int i = 0; i < moveFrom.length; i++) {
                positionSets.remove(moveFrom[i]);
                positionSets.add(moveTo[i]);
            }


//            List<Integer> objects =

            List<Integer> collect = positionSets.stream().sorted().collect(Collectors.toList());

            return collect;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
