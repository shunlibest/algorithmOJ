package com.其他;

public class Code299_猜数字游戏 {
    public static void main(String[] args) {
        String a = "1123";
        String b = "0111";
        String hint = new Code299_猜数字游戏().getHint(a, b);
        System.out.println(hint);
    }

    public String getHint(String secret, String guess) {
        int length = secret.length();

        //数字和确切位置都猜对了
        int bulls = 0;


        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < length; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }

        // 数字猜对了但是位置不对
        int cows = 0;
        for (int i = 0; i < secretCount.length; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}
