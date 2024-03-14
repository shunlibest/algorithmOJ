package com.数组;

import java.util.Arrays;

public class Code2129_将标题首字母大写 {

    public static void main(String[] args) {
        String input = "ZW Cl pyR uoC";
        String res = new Code2129_将标题首字母大写().capitalizeTitle(input);
        System.out.println(res);
    }

    public String capitalizeTitle(String title) {
        char[] chars = title.toLowerCase().toCharArray();
        int wordStartIndex = 0;

        for (int i = 0; i < chars.length + 1; i++) {
            if (i < chars.length && chars[i] != ' ') {
                continue;
            }
            if (i - wordStartIndex > 2) {
                chars[wordStartIndex] = (char) (chars[wordStartIndex] - 'a' + 'A');
            }
            wordStartIndex = i + 1;
        }
        return String.valueOf(chars);
    }
}
