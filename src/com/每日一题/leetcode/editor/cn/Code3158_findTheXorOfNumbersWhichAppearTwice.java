package com.每日一题.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * [每日一题] 2024-10-12 10:29:54
 * 题目名称: 求出出现两次数字的 XOR 值
 * 题目类型:
 * 思考:
 */


public class Code3158_findTheXorOfNumbersWhichAppearTwice {
    public static void main(String[] args) {
        Solution solution = new Code3158_findTheXorOfNumbersWhichAppearTwice().new Solution();
        int[] i0 = {1, 2, 1, 3};
        int[] i1 = {1, 2, 2, 1};
        int i = solution.duplicateNumbersXOR(i1);

        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int duplicateNumbersXOR(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int result = 0;

            for (Integer integer : set) {
                result ^= integer;
            }
            for (int num : nums) {
                result ^= num;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
