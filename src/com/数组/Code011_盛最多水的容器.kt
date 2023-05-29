package com.数组

import kotlin.math.*


fun main() {
    val nums = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
//    val nums = intArrayOf(1,0,0,0,0,0,0,0,7)


    val value = maxArea(nums)
    println(value);
}


fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1

    var maxWater = 0
    while (left < right) {
        maxWater = max(maxWater, min(height[left], height[right]) * (right - left))
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxWater
}