package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2025-02-05 10:46:13
 * 题目名称: 子集
 * 题目类型:
 * 思考:
 */


public class Code78_subsets {
    public static void main(String[] args) {
        Solution solution = new Code78_subsets().new Solution();
        int[] i0 = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(i0);
        Utils.printTable(subsets);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> currentList = new ArrayList<>();
            subsets(nums, result, currentList, 0);

//
            return result;
        }

        private void subsets(int[] nums, List<List<Integer>> result, List<Integer> currentList, int start) {
//            if (start >= nums.length) {
//                return;
//            }
            result.add(new ArrayList<>(currentList));


//            List<Integer> newList = new ArrayList<>(currentList);
            for (int i = start; i < nums.length; i++) {
                currentList.add(nums[i]);
                subsets(nums, result, currentList, i + 1);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
