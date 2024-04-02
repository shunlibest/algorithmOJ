package com.其他;

import java.util.HashMap;
import java.util.Map;

public class Code2671_频率跟踪器 {
    public static void main(String[] args) {
        FrequencyTracker frequencyTracker = new FrequencyTracker();
//        frequencyTracker.add(3); // 数据结构现在包含 [3]
//        frequencyTracker.add(3); // 数据结构现在包含 [3, 3]
//        System.out.println(frequencyTracker.hasFrequency(2)); // 返回 true ，因为 3 出现 2 次

        frequencyTracker.add(3);
        frequencyTracker.add(6);
        frequencyTracker.add(2);
        frequencyTracker.add(6);
        frequencyTracker.deleteOne(6);
        frequencyTracker.deleteOne(6);


        frequencyTracker.add(2);
        System.out.println(frequencyTracker.hasFrequency(1)); // 返回 false ，

    }

    static class FrequencyTracker {
        private Map<Integer, Integer> valueMap = new HashMap<>();
        private Map<Integer, Integer> countMap = new HashMap<>();


        public FrequencyTracker() {

        }

        public void add(int number) {
            int numCount = valueMap.getOrDefault(number, 0);
            valueMap.put(number, numCount + 1);

            int frequency = countMap.getOrDefault(numCount, 0);
            countMap.put(numCount, Math.max(frequency - 1, 0));
            int frequencyAdd = countMap.getOrDefault(numCount + 1, 0);
            countMap.put(numCount + 1, frequencyAdd + 1);

        }

        public void deleteOne(int number) {
            int numCount = valueMap.getOrDefault(number, 0);
            valueMap.put(number, Math.max(numCount - 1, 0));

            int frequency = countMap.getOrDefault(numCount, 0);
            countMap.put(numCount, Math.max(frequency - 1, 0));

            int frequencyAdd = countMap.getOrDefault(numCount - 1, 0);
            countMap.put( Math.max(numCount - 1, 0), frequencyAdd + 1);
        }

        public boolean hasFrequency(int frequency) {
            return countMap.getOrDefault(frequency, 0) > 0;
        }
    }
}
