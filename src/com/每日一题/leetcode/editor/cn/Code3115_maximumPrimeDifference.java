package com.每日一题.leetcode.editor.cn;

import com.Utils;

/**
 * [每日一题] 2024-07-02 11:15:54
 * 题目名称: 质数的最大距离
 * 题目类型:
 * 思考:
 */
public class Code3115_maximumPrimeDifference {
    public static void main(String[] args) {
        Solution solution = new Code3115_maximumPrimeDifference().new Solution();
        int[] array = {1,7};
        int i = solution.maximumPrimeDifference(array);
        System.out.println(i);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumPrimeDifference(int[] nums) {

            int firstPrimeIndex = -1;
            for (int i = 0; i < nums.length; i++) {
                if (isPrime(nums[i])) {
                    firstPrimeIndex = i;
                    break;
                }
            }

            int finalPrimeIndex = -1;
            for (int i = nums.length - 1; i >= firstPrimeIndex; i--) {
                if (isPrime(nums[i])) {
                    finalPrimeIndex = i;
                    break;
                }
            }

//            System.out.println(firstPrimeIndex);
//            System.out.println(finalPrimeIndex);

            return finalPrimeIndex - firstPrimeIndex;

        }


        private boolean isPrime(int num) {
            if (num==1){
                return false;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
