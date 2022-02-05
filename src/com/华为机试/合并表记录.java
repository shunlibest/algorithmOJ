package com.华为机试;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class 合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int inputCount = in.nextInt();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < inputCount; i++) {
            int k = in.nextInt();
            int v = in.nextInt();

            Integer integer = treeMap.get(k);
            int ceilValue = 0;
            if (integer !=null){
                ceilValue = integer;
            }

            treeMap.put(k,v+ceilValue);
        }

        for (Map.Entry<Integer,Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
