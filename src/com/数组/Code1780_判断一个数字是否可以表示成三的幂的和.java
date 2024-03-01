package com.数组;

public class Code1780_判断一个数字是否可以表示成三的幂的和 {

    public static void main(String[] args) {
        boolean b = new Code1780_判断一个数字是否可以表示成三的幂的和().checkPowersOfThree(11);
        System.out.println(b);
    }

    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
