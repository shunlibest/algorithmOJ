package com.每日一题.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [每日一题] 2024-06-20 09:51:05
 * 题目名称: 美丽下标对的数目
 * 题目类型:
 * 思考:
 */
public class Code2748_numberOfBeautifulPairs {
    public static void main(String[] args) {
        Solution solution = new Code2748_numberOfBeautifulPairs().new Solution();
        int[] array = {2,5,1,4};
        int i = solution.countBeautifulPairs(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBeautifulPairs(int[] nums) {
            Map<Integer, Integer> firstNumMap = new HashMap<>();
            Map<Integer, Integer> finalNumMap = new HashMap<>();

            int result = 0;
            for (int num : nums) {
                int finalNum = num % 10;
                int firstNum = num;
                while (firstNum >= 10) {
                    firstNum /= 10;
                }

                for (int i = 1; i < 10; i++) {
                    if (isGcd(finalNum, i)) {
                        result += firstNumMap.getOrDefault(i, 0);
//                        System.out.println(finalNum + "," + i);
                    }
                }
                firstNumMap.put(firstNum, firstNumMap.getOrDefault(firstNum, 0) + 1);
                finalNumMap.put(finalNum, finalNumMap.getOrDefault(finalNum, 0) + 1);
            }
            return result;
        }

        private boolean isGcd(int a, int b) {
            int min = Math.min(a, b);
            for (int i = 2; i <= min; i++) {
                if (a % i == 0 && b % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
