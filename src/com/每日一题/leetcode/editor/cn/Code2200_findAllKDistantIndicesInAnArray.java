package com.每日一题.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2025-06-24 10:45:09
 * 题目名称: 找出数组中的所有 K 近邻下标
 * 题目类型:
 * 思考:
 */


public class Code2200_findAllKDistantIndicesInAnArray {
    public static void main(String[] args) {
        Solution solution = new Code2200_findAllKDistantIndicesInAnArray().new Solution();
        int[] i0 = {3, 4, 9, 1, 3, 9, 5};
        Object i1 = 1;
        Object i2 = 2;
        List<Integer> kDistantIndices = solution.findKDistantIndices(i0, 9, 1);
        System.out.println(kDistantIndices);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

            List<Integer> result = new ArrayList<>();
            int currentEqualIndex = findNextEqual(nums, 0, key);
            for (int i = 0; i < nums.length; i++) {
                if (Math.abs(currentEqualIndex - i) <= k) {
                    result.add(i);
                } else {
                    if (currentEqualIndex < i) {
                        currentEqualIndex = findNextEqual(nums, currentEqualIndex + 1, key);
                    }
                    if (Math.abs(currentEqualIndex - i) <= k) {
                        result.add(i);
                    }
                }

            }

            return result;
        }


        private int findNextEqual(int[] nums, int currentEqualIndex, int key) {

            for (int i = currentEqualIndex; i < nums.length; i++) {
                if (nums[i] == key) {
//                    System.out.println(i);
                    return i;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
