package com.每日一题.leetcode.editor.cn;

/**
 * [每日一题] 2025-02-10 16:18:49
 * 题目名称: 搜索旋转排序数组
 * 题目类型:
 * 思考:
 */


public class Code33_searchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new Code33_searchInRotatedSortedArray().new Solution();
//        int[] i0 = {4, 5, 6, 7, 0, 1, 2};
//        int[] i0 = {4,5,6,7,0,1,2};
//        Object i2 = {1};
        int[] i0 = {1, 3, 5};
        int search = solution.search(i0, 3);
        System.out.println(search);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int startIndex = findStartIndex(nums);

            int leftIndex = 0;
            int rightIndex = nums.length - 1;


            // 0 1 2 4 5 6 7
            while (leftIndex <= rightIndex) {
                int centerIndex = (leftIndex + rightIndex) / 2;
                int centerValue = getFixedValue(nums, startIndex, centerIndex);
//                System.out.println("centerIndex:" + centerIndex);
                if (centerValue > target) {
                    rightIndex = centerIndex - 1;
                } else if (centerValue < target) {
                    leftIndex = centerIndex + 1;
                } else {
                    return (centerIndex + startIndex) % nums.length;
                }
            }
            return -1;
        }

        private int getFixedValue(int[] nums, int startIndex, int index) {
            return nums[(index + startIndex + nums.length) % nums.length];
        }

        private int findStartIndex(int[] nums) {
            int endValue = nums[nums.length - 1];
            int leftIndex = 0;
            int rightIndex = nums.length - 1;


//            if (endValue > nums[1]){
//                return 0;
//            }

            //3 4 5 6 7 8 9 10 1 2
//            int max
            while (leftIndex <= rightIndex) {
                int centerIndex = (leftIndex + rightIndex) / 2;
//                System.out.println("centerIndex:" + centerIndex);
                if (nums[centerIndex] > endValue) {
                    leftIndex = centerIndex + 1;
                } else if (nums[centerIndex] < endValue) {
                    rightIndex = centerIndex - 1;
                } else {
                    return leftIndex;
                }
            }

//            System.out.println(leftIndex);
//            System.out.println(rightIndex);

            if (rightIndex == -1) {
                return 0;
            }

//            if (rightIndex)

            return (rightIndex + 1) % nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
