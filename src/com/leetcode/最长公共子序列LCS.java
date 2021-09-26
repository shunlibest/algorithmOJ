package com.leetcode;

public class 最长公共子序列LCS {

//

    public static void main(String[] args) {
        char[] charA = "ABABABA".toCharArray();
        char[] charB = "ABABABA".toCharArray();


    }


    public static String[][] LCS_length(char[] charA, char[] charB){
        int m = charA.length;
        int n = charB.length;

        int[][] c = new int[m][n];
        String[][] b = new String[m][n];

        // 对表b和表c进行初始化
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                c[i][j] = 0;
                b[i][j] = "";
            }
        }

        // 利用自底向上的动态规划法获取b和c的值
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(X.get(i-1) == Y.get(j-1)){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = "diag";
                }
                else if(c[i-1][j] >= c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = "up";
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = "left";
                }
            }
        }

        return b;
    }

}
