package com.数组

import java.util.*

fun main(args: Array<String>) {
    val k = intArrayOf(0)

    moveZeroes(k)

    println(Arrays.toString(k))
}

fun moveZeroes(nums: IntArray) {
    var left = 0
    var right = 1


    while (right < nums.size) {
        if (nums[left] != 0) {
            left++
        }
        nums[left] = nums[right]
        right++
    }

    left++
    while (left < nums.size) {
        nums[left] = 0
        left++
    }
}