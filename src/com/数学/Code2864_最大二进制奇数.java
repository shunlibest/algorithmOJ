package com.数学;

public class Code2864_最大二进制奇数 {
    public static void main(String[] args) {
        String input = "010";
        String s = new Code2864_最大二进制奇数().maximumOddBinaryNumber(input);
        System.out.println(s);

    }

    public String maximumOddBinaryNumber(String s) {
        char[] chars = s.toCharArray();
        int oneCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                oneCount++;
                chars[i] = '0';
            }
        }
        if (oneCount > 0) {
            chars[chars.length - 1] = '1';
            for (int i = 0; i < oneCount - 1; i++) {
                chars[i] = '1';
            }
        }

        return new String(chars);
    }
}
