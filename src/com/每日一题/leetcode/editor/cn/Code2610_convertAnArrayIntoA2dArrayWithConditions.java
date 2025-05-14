package com.每日一题.leetcode.editor.cn;

import com.Utils;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * [每日一题] 2025-03-19 11:05:13
 * 题目名称: 转换二维数组
 * 题目类型:
 * 思考:
 */
 

public class Code2610_convertAnArrayIntoA2dArrayWithConditions{
    public static void main(String[] args) {
        Solution solution = new Code2610_convertAnArrayIntoA2dArrayWithConditions().new Solution();
        int[] i0 = {1,3,4,1,2,3,1};
        List<List<Integer>> matrix = solution.findMatrix(i0);

        Utils.printTable(matrix);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {


        List<HashSet<Integer>> result = new ArrayList<>();

        for (int num : nums) {
            boolean isAdded = false;
            for (HashSet<Integer> integers : result) {
                if (!integers.contains(num)){
                    integers.add(num);
                    isAdded = true;
                    break;
                }
            }

            if (!isAdded){
                HashSet<Integer> newSet = new HashSet<>();
                newSet.add(num);
                result.add(newSet);
            }
        }


        List<List<Integer>> output = new ArrayList<>();

        for (HashSet<Integer> integers : result) {

            List<Integer> list = new ArrayList<Integer>(integers);
//            System.out.println("list content: " + list);

            output.add(list);
        }


        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
