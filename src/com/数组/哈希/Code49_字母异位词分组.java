package com.数组.哈希;

import java.util.*;

public class Code49_字母异位词分组 {
    public static void main(String[] args) {
        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Code49_字母异位词分组().groupAnagrams(array);
        System.out.println(lists);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String item : strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(item);
        }
        return new ArrayList<>(map.values());
    }
}
