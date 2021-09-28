package com.数组;

import java.util.Arrays;

public class Code134_加油站 {


    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
//
//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};
//
//
//        int[] gas = new int[]{5, 1, 2, 3, 4};
//        int[] cost = new int[]{4, 4, 1, 5, 1};


        int hint = canCompleteCircuit(gas, cost);
        System.out.println(hint);

    }

    /**
     * 灵感：用多级方式解决； 当遇到某一case之后，抓住该case，然后基于这一case循环
     */

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] remainGas = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remainGas[i] = gas[i] - cost[i];
        }
        System.out.println(Arrays.toString(remainGas));

        int i = 0;
        int currentGas = 0;
        int startPos = 0;
        while (i < gas.length) {
            currentGas += remainGas[i];

            //油量不够
            if (currentGas < 0) {
                i++;
                currentGas = 0;
                startPos = i;
                continue;
            } else {
                startPos = i;
                while (currentGas >= 0) {
                    i++;
                    currentGas += remainGas[i % gas.length];

                    if (startPos == i % gas.length) {
                        return startPos;
                    }
                }
            }
        }


        return -1;
    }

    public static int canCompleteCircuit001(int[] gas, int[] cost) {
        int[] remainGas = new int[gas.length];
        for (int i = 0; i < gas.length; i++) {
            remainGas[i] = gas[i] - cost[i];
        }
        System.out.println(Arrays.toString(remainGas));

        int currentGas = 0;
        int startPos = 0;
        for (int i = 0; i < gas.length * 2 + 1; i++) {
            int ii = i % gas.length;
//            if (remainGas[ii] < 0) {
//                continue;
//            }
            currentGas += remainGas[ii];

            if (currentGas < 0) {
                currentGas = 0;
                startPos = ii + 1;


            }


            if (startPos == i) {
                return startPos;
            }

        }

        if (currentGas <= 0) {
            return -1;

        }

        return startPos;
    }
}
