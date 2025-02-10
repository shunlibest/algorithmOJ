package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-10-18 11:26:29
 * 题目名称: 使二进制数组全部等于 1 的最少操作次数 I
 * 题目类型:
 * 思考:
 */


public class Code3191_minimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public static void main(String[] args) {
        Solution solution = new Code3191_minimumOperationsToMakeBinaryArrayElementsEqualToOneI().new Solution();
        int[] i0 = {0, 1, 1, 1, 0, 0};
        int i = solution.minOperations(i0);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {

            int result = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] == 0) {
                    result++;
                    reverse(nums, i);
                }
            }

            if (nums[nums.length - 2] == 1 && nums[nums.length - 1] == 1) {
                return result;
            }

            return -1;
        }

        private void reverse(int[] nums, int start) {
            for (int i = 0; i < 3; i++) {
                nums[start + i] ^= 1;
            }

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
