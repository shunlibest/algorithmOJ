package com.数组


fun main() {
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)


    val value = threeSum(nums)
    println(value.toString());
}


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()

    val allNumsSet = nums.toHashSet()

    val result = mutableListOf<List<Int>>()


    val size = nums.size


    var lastI = Int.MAX_VALUE - 1
    var lastJ = Int.MAX_VALUE - 1

    for (i in 0 until size) {
        if (lastI == nums[i]) {
            continue
        }
        lastI = nums[i]
        if (lastI > 0) {
            return result
        }
        for (j in i + 1 until size) {
            if (lastJ == nums[j]) {
                continue
            }
            lastJ = nums[j]
            val needValue = -nums[i] - nums[j]
            if (needValue > nums[j]) {
                if (allNumsSet.contains(needValue)) {
                    val list = arrayListOf(nums[i], nums[j], needValue)
                    result.add(list)
                }
            } else if (needValue == nums[j]) {
                if (j < size - 1 && nums[j + 1] == needValue) {
                    val list = arrayListOf(nums[i], nums[j], needValue)
                    result.add(list)
                }
            } else {
                break
            }
        }
    }

    return result
}


fun threeSumError(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val size = nums.size
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            for (k in j + 1 until size) {
                val res = nums[i] + nums[j] + nums[k]
                if (res == 0) {
                    val list = arrayListOf(nums[i], nums[j], nums[k])
                    result.add(list)
                }
            }
        }
    }
    return result
}