package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2024-09-27 09:56:58
 * 题目名称: 每种字符至少取 K 个
 * 题目类型:
 * 思考:
 */


public class Code2516_takeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        Solution solution = new Code2516_takeKOfEachCharacterFromLeftAndRight().new Solution();
        Object i0 = "aabaaaacaabc";
        Object i1 = "a";
        int aabaaaacaabc = solution.takeCharacters("acbcc", 1);
        System.out.println(aabaaaacaabc);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeCharacters(String s, int k) {
            if (k == 0) {
                return 0;
            }

            char[] chars = s.toCharArray();
            int[] count = new int[3];
            for (char aChar : chars) {
                count[aChar - 'a']++;
            }

            for (int i = 0; i < count.length; i++) {
                count[i] = count[i] - k;
                if (count[i] < 0) {
                    return -1;
                }
            }
            int left = 0;
            int right = 0;

            int maxRemoveLength = 0;

            while (right < s.length()) {
                boolean good = isGood(count);
                if (good) {
//                    System.out.println(s.substring(left, right));
                    maxRemoveLength = Math.max(maxRemoveLength, right - left);
                    count[chars[right] - 'a']--;
                    right++;


                } else {
                    count[chars[left] - 'a']++;
                    left++;
                }
            }

            boolean good = isGood(count);
            if (good) {
                maxRemoveLength = Math.max(maxRemoveLength, right - left);
            }

            return s.length() - maxRemoveLength;

        }


        private boolean isGood(int[] nums) {
            for (int num : nums) {
                if (num < 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
