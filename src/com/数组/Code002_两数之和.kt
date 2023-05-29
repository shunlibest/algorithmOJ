package com.数组


fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    val value = twoSum(nums, target)
    println(value.contentToString());
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, it ->
        val need = target - it
        if (map.contains(need)) {
            return intArrayOf(map[need]!!, index)
        } else {
            map[it] = index
        }
    }
    return intArrayOf()
}