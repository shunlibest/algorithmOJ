package com.数组;

public class Code2917_找出数组中的Kor值 {
    public static void main(String[] args) {
        int[] array = {7,12,9,8,9,15};
        int kOr = new Code2917_找出数组中的Kor值().findKOr(array, 4);
        System.out.println(kOr);
    }


    public int findKOr(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int positionCount = 0;
            for (int num : nums) {
                int v = (num & (1 << i)) >> i;
                positionCount += v;
            }
            if (positionCount >= k) {
                sum += (1 << i);
            }
        }
        return sum;
    }
}
