package com.每日一题.leetcode.editor.cn;

import com.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * [每日一题] 2024-09-02 13:48:13
 * 题目名称: 全排列
 * 题目类型:
 * 思考:
 */


public class Code46_permutations {
    public static void main(String[] args) {
        Solution solution = new Code46_permutations().new Solution();
        int[] i0 = {1, 2, 3};
//        Object i1 = {1};
        List<List<Integer>> permute = solution.permute(i0);

        Utils.printTable(permute);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            List<Integer> current = new ArrayList<>();
            backtrack(result, nums, visited, current);

            return result;
        }


        public void backtrack(List<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> current) {
            if (current.size() == nums.length) {
                result.add(new ArrayList<>(current));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                current.add(nums[i]);
                backtrack(result, nums, visited, current);
                current.remove(current.size() - 1);

                visited[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
