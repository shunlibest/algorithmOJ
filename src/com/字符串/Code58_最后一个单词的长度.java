package com.字符串;

public class Code58_最后一个单词的长度 {

    public static void main(String[] args) {

        int i = lengthOfLastWord("a");
        System.out.println(i);
    }

    public static int lengthOfLastWord(String s) {

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            int jjj = i ;
            for (int j = i - 1; j >= 0; j--) {
                char cc = s.charAt(j);
                if (cc == ' ') {
                    return i - j;
                }
            }

            return jjj+1;
        }

        return s.length();
    }
}
