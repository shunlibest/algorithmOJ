package com.数组

import kotlin.math.absoluteValue


fun main() {
    val nums = intArrayOf(-1, 2, 1, -4)
    val target = 1


    val value = threeSumClosestO3(nums, target)
    println(value.toString());
}



fun threeSumClosest(nums: IntArray, target: Int): Int {
    var minGaps = Int.MAX_VALUE

    val size = nums.size
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            for (k in j + 1 until size) {
                val res = nums[i] + nums[j] + nums[k]
                val gap = res - target
                if (gap.absoluteValue < minGaps.absoluteValue) {
                    minGaps = gap
                }
            }
        }
    }
    return minGaps + target
}

/**
 * 三重循环, 通过
 * 速度 13%
 */
fun threeSumClosestO3(nums: IntArray, target: Int): Int {
    var minGaps = Int.MAX_VALUE

    val size = nums.size
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            for (k in j + 1 until size) {
                val res = nums[i] + nums[j] + nums[k]
                val gap = res - target
                if (gap.absoluteValue < minGaps.absoluteValue) {
                    minGaps = gap
                }
            }
        }
    }
    return minGaps + target
}

