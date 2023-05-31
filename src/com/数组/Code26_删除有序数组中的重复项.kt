package com.数组

import java.util.*

fun main(args: Array<String>) {
    val k = intArrayOf(1, 1, 2)
    val i = removeDuplicates(k)
    println(i)
    println(Arrays.toString(k))
}

fun removeDuplicates(nums: IntArray): Int {
    var slow = 0
    var fast = 0
    while (fast < nums.size) {
        while (nums[fast] == nums[slow]) {
            fast++
            if (fast >= nums.size) {
                return ++slow
            }
        }
        slow++
        nums[slow] = nums[fast]
    }
    return slow
}
