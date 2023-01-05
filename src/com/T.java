package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T {

    private static final String replaceRegex = "#(\\w+)#";
    private static final Pattern pattern = Pattern.compile(replaceRegex);

    public static void main(String[] args) {
        String attributeValue = "11#1231#88#11#";
        List<String> strList = findStrList(attributeValue);

        for (String s : strList) {
            System.out.println(s);
        }

    }

    /**
     * 查找满足正则匹配条件的所有字符串
     *
     * @param source 需要查找的字符串
     * @return 查找结果集
     */
    public static List<String> findStrList(String source) {
        Matcher matcher = pattern.matcher(source);
        List<String> matchStr = new ArrayList<>();
        while (matcher.find()) {
//            matcher.
            matchStr.add(matcher.group());
        }
        return matchStr;
    }


}
