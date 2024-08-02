package com.每日一题.leetcode.editor.cn;

import java.util.*;

/**
 * [每日一题] 2024-06-11 15:14:04
 * 题目类型: 遍历
 * 思考:
 */
public class Code398_随机数索引 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3};
        Solution solution = new Code398_随机数索引().new Solution(array);
        System.out.println(solution.pick(3));
        System.out.println(solution.pick(1));
        System.out.println(solution.pick(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> indexSet = map.get(nums[i]);
                if (indexSet == null) {
                    indexSet = new ArrayList<>();
                    indexSet.add(i);
                    map.put(nums[i], indexSet);
                } else {
                    indexSet.add(i);
                }
            }
        }

        public int pick(int target) {
            List<Integer> integers = map.get(target);
            count++;
            return integers.get(count % integers.size());
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
