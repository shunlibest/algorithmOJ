package com.字符串;

public class Code14_最长公共前缀 {

    public static void main(String[] args) {

//        String[] strs = new String[]{"dog", "racecar", "car"};
        String[] strs = new String[]{"ab", "ab", "a"};

        String i = longestCommonPrefix(strs);
        System.out.println(i);
    }

    public static String longestCommonPrefix(String[] strs) {

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length() && strs[0].charAt(i) == strs[j].charAt(i)) {
                    continue;
                } else {
                    return strs[0].substring(0, i);
                }
            }

            if (i == strs[0].length() - 1) {
                return strs[0];
            }
        }


        return "";
    }
}
