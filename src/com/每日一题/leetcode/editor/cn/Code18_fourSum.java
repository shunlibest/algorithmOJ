package com.每日一题.leetcode.editor.cn;

import java.util.*;

/**
 * [每日一题] 2024-08-30 14:15:07
 * 题目名称: 四数之和
 * 题目类型:
 * 思考:
 */


public class Code18_fourSum {
    public static void main(String[] args) {
        Solution solution = new Code18_fourSum().new Solution();
        int[] i0 = {1, 0, -1, 0, -2, 2};
        int[] i1 = {2, 2, 2, 2, 2};
        int[] i3 = {-500, -499, -486, -474, -470, -462, -426, -426, -411, -409, -366, -361, -359, -355, -350, -349, -303, -297, -255, -238, -222, -215, -203, -201, -198, -193, -193, -187, -179, -156, -150, -139, -99, -93, -87, -58, -54, -8, -2, 1, 5, 6, 8, 9, 15, 31, 37, 48, 50, 95, 128, 181, 201, 206, 235, 244, 251, 272, 285, 287, 289, 305, 308, 338, 357, 367, 386, 391, 392, 395, 395, 402, 410, 449, 458, 466, 478, 485, 488};
        List<List<Integer>> lists = solution.fourSum(i3, -2701);

        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            Set<String> set = new HashSet<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {


                            String key = nums[i] + "," + nums[j] + "," + nums[k] + "," + nums[l];

                            if (set.contains(key)) {
                                continue;
                            }

                            if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                                List<Integer> list = new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[k]);
                                list.add(nums[l]);
                                result.add(list);
                                set.add(key);
                            }


                        }
                    }
                }
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
