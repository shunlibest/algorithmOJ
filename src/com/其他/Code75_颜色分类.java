package com.其他;

import java.util.Arrays;

public class Code75_颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        new Code75_颜色分类().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;

                if (p0 == p1) {
                    p0++;
                    p1++;
                } else  {
                    // p0 < p1
                    nums[i] = nums[p1];

                }
            }
        }

    }


    //class Solution {
    //    public void sortColors(int[] nums) {
    //        int n = nums.length;
    //        int p0 = 0, p1 = 0;
    //        for (int i = 0; i < n; ++i) {
    //            if (nums[i] == 1) {
    //                int temp = nums[i];
    //                nums[i] = nums[p1];
    //                nums[p1] = temp;
    //                ++p1;
    //            } else if (nums[i] == 0) {
    //                int temp = nums[i];
    //                nums[i] = nums[p0];
    //                nums[p0] = temp;
    //                if (p0 < p1) {
    //                    temp = nums[i];
    //                    nums[i] = nums[p1];
    //                    nums[p1] = temp;
    //                }
    //                ++p0;
    //                ++p1;
    //            }
    //        }
    //    }
    //}
    //
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
