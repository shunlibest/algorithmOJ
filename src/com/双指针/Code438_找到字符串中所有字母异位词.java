package com.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> res = new Code438_找到字符串中所有字母异位词().findAnagrams(s, p);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();

        if (sChars.length < pChars.length) {
            return res;
        }

        int[] charCount = new int[26];


        for (int i = 0; i < pChars.length; i++) {
            charCount[pChars[i] - 'a']--;
            charCount[sChars[i] - 'a']++;
        }
        if (isAllSame(charCount)) {
            res.add(0);
        }

        for (int i = pChars.length; i < sChars.length; i++) {
            charCount[sChars[i] - 'a']++;
            charCount[sChars[i - pChars.length] - 'a']--;

            if (isAllSame(charCount)) {
                res.add(i - pChars.length + 1);
            }
        }
        return res;
    }

    private boolean isAllSame(int[] count) {
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
