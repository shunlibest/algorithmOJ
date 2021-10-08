package com.回溯法;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Code17_电话号码的字母组合 {

    public static void main(String[] args) {
        List<String> i = new Code17_电话号码的字母组合().letterCombinations("");
        System.out.println(i);
    }

    // 存放所有的结果
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()){
            return new ArrayList<>();
        }

        numToCharSet();

        letterCombinationsHelper(digits, new StringBuilder());

        return result;
    }

    void letterCombinationsHelper(String digits, StringBuilder outputString) {
        if (digits.isEmpty()) {
            result.add(outputString.toString());
            return;
        }

        int num = digits.charAt(0) - '0';
        char[] chars = charSet[num].toCharArray();
        for (char c : chars) {
            outputString.append(c);
            letterCombinationsHelper(digits.substring(1), outputString);
            outputString.deleteCharAt(outputString.length() - 1);
        }
    }

    String[] charSet = new String[10];

    void numToCharSet() {
        charSet[0] = "";
        charSet[1] = "";
        charSet[2] = "abc";
        charSet[3] = "def";
        charSet[4] = "ghi";
        charSet[5] = "jkl";
        charSet[6] = "mno";
        charSet[7] = "pqrs";
        charSet[8] = "tuv";
        charSet[9] = "wxyz";
    }

}
