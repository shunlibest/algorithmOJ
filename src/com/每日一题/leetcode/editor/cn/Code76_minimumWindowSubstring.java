package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * [每日一题] 2024-09-04 14:37:18
 * 题目名称: 最小覆盖子串
 * 题目类型:
 * 思考:
 */


public class Code76_minimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Code76_minimumWindowSubstring().new Solution();
        Object i0 = "ADOBECODEBANC";
        Object i1 = "a";
        Object i2 = "a";
        String s = solution.minWindow("a", "aa");
        System.out.println(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s.equals(t)) {
                return s;
            }


            // 双指针

            Map<Character, Integer> clearMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                int count = clearMap.getOrDefault(c, 0);
                clearMap.put(c, count + 1);
            }
            Set<Character> set = new HashSet<>(clearMap.keySet());
            Map<Character, Integer> saveMap = new HashMap<>();


            int left = 0;

            int startRange = 0;
            int endRange = 0;

            int min = Integer.MAX_VALUE;


            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);

                if (!set.contains(currentChar)) {
                    continue;
                }

                if (clearMap.containsKey(currentChar)) {
                    int count = clearMap.getOrDefault(currentChar, 0) - 1;
                    if (count == 0) {
                        clearMap.remove(currentChar);
                    } else {
                        clearMap.put(currentChar, count);
                    }
                } else {
                    int count = saveMap.getOrDefault(currentChar, 0) + 1;
                    saveMap.put(currentChar, count);
                }

                if (clearMap.isEmpty()) {
                    while (true) {
                        char leftChar = s.charAt(left);
                        if (!set.contains(leftChar)) {
                            left++;
                            continue;
                        }

                        int saveCount = saveMap.getOrDefault(leftChar, 0);
                        if (saveCount > 0) {
                            saveMap.put(leftChar, saveCount - 1);
                            left++;
                        } else {
                            break;
                        }
                    }
                    if (i - left < min) {
                        min = i - left;
                        startRange = left;
                        endRange = i;
                    }
                }
            }

            if (!clearMap.isEmpty()) {
                return "";
            }
//            System.out.println(range);

//            System.out.println(min);


//            System.out.println();

            return s.substring(startRange, endRange + 1);
        }

        private int charToIndex(char c) {
            if (c <= 'Z') {
                return c - 'A';
            }
            return c - 'a';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
