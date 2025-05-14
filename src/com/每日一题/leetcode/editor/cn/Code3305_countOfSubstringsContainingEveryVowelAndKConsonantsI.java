package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2025-03-12 14:29:19
 * 题目名称: 元音辅音字符串计数 I
 * 题目类型:
 * 思考:
 */


public class Code3305_countOfSubstringsContainingEveryVowelAndKConsonantsI {
    public static void main(String[] args) {
        Solution solution = new Code3305_countOfSubstringsContainingEveryVowelAndKConsonantsI().new Solution();
        Object i0 = "aeioqq";
        Object i1 = "aeiou";
        String i2 = "ieaouqqieaouqq";
        int aeioux = solution.countOfSubstrings("iqeaouqi", 2);

        System.out.println(aeioux);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countOfSubstrings(String word, int k) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('a', 0);
            map.put('e', 1);
            map.put('i', 2);
            map.put('o', 3);
            map.put('u', 4);

            int[] currentCount = new int[6];
            int result = 0;
            char[] chars = word.toCharArray();

            for (int i = 0; i < 5 + k; i++) {
                Integer index = map.getOrDefault(chars[i], 5);
                currentCount[index]++;
            }

            if (isOk(currentCount)) {
                result++;
            }


            for (int i = 5 + k; i < chars.length; i++) {

                Integer addIndex = map.getOrDefault(chars[i], 5);
                currentCount[addIndex]++;

                Integer removeIndex = map.getOrDefault(chars[i - k - 5], 5);
                currentCount[removeIndex]--;

                if (isOk(currentCount)) {
                    result++;
                }
            }

            return result;
        }

        public boolean isOk(int[] array) {
            for (int i = 0; i < 5; i++) {
                if (array[i] != 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
