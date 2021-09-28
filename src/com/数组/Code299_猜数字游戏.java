package com.数组;

import java.util.HashMap;

public class Code299_猜数字游戏 {


    public static void main(String[] args) {
//        int[] k = new int[]{1, 1};
//        int[] k = new int[]{3, 4, -1, 1};
        int[] k = new int[]{1, 2, 3, 4, 5};

        String hint = getHint("1122", "1222");
        System.out.println(hint);

    }

    public static String getHint(String secret, String guess) {
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        int A = 0;
        int B = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char a : secretChars) {
            Integer integer = hashMap.get(a);
            int value = 0;
            if (integer == null) {
                value = 1;
            } else {
                value = integer + 1;
            }
            hashMap.put(a, value);
        }

//        System.out.println(Arrays.toString(hashMap));


        //公牛
        for (int i = 0; i < secretChars.length; i++) {
            if (secretChars[i] == guessChars[i]) {
                A++;
                Integer integer = hashMap.get(secretChars[i]);
                hashMap.put(secretChars[i], integer - 1);
            }
        }

        //奶牛

//
        int i = -1;
        for (char b : guessChars) {
            i++;
            if (secretChars[i] == guessChars[i]) {
                continue;
            }
            if (hashMap.containsKey(b) && hashMap.get(guessChars[i]) >= 1) {
                B++;
                System.out.println(b);

                Integer integer = hashMap.get(guessChars[i]);
                if (integer > 1) {
                    hashMap.put(guessChars[i], integer - 1);

                } else {
                    hashMap.remove(guessChars[i]);
                }
            }
        }


        return A + "A" + B + "B";
    }
}
