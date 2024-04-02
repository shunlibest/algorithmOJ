package com.字符串;

public class Code1071_字符串的最大公因子 {
    public static void main(String[] args) {
        String str1 = "ABABAB", str2 = "ABAB";
        String s = new Code1071_字符串的最大公因子().gcdOfStrings(str1, str2);
        System.out.println(s);
    }

    public String gcdOfStrings(String str1, String str2) {
        String shortLength;
        String longLength;
        if (str1.length() < str2.length()) {
            shortLength = str1;
            longLength = str2;
        } else {
            shortLength = str2;
            longLength = str1;
        }

        for (int i = shortLength.length(); i >= 1; i--) {
            String same = longLength.substring(0, i);
            if (isRepeat(str1, same) && isRepeat(str2, same)) {
                return same;
            }

        }
        return "";
    }

    private boolean isRepeat(String str, String repeatValue) {
        for (int i = 0; i < str.length(); i += repeatValue.length()) {
            if (!str.startsWith(repeatValue, i)) {
                return false;
            }
        }
        return true;
    }


}
