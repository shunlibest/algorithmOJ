package com.字符串;

public class Code1768_交替合并字符串 {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        String s = new Code1768_交替合并字符串().mergeAlternately(word1, word2);
        System.out.println(s);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.min(word1.length(), word2.length());
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        for (int i = 0; i <length; i++) {
            sb.append(word1Chars[i]);
            sb.append(word2Chars[i]);
        }
        if (word1Chars.length > word2Chars.length){
            sb.append(word1.substring(length));
        }else if (word2Chars.length > word1Chars.length){
            sb.append(word2.substring(length));
        }
        return sb.toString();
    }
}
