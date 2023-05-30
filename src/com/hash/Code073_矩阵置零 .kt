package com.hash

import java.util.Arrays


fun main() {
    val nums = Array(4) { i: Int -> IntArray(4) }

    nums[0] = intArrayOf(1, 1, 1, 2, 1)
    nums[1] = intArrayOf(1, 0, 1, 3, 1)
    nums[2] = intArrayOf(1, 1, 1, 0, 1)
    nums[3] = intArrayOf(1, 1, 1, 0, 1)


    val value = setZeroes(nums)

    nums.forEach {
        println(it.contentToString());
    }
}

fun setZeroes(matrix: Array<IntArray>): Unit {
    val rowMark = mutableListOf<Int>()

    val rowSize = matrix.size       //3
    val columSize = matrix[0].size  //2
    for (i in 0 until rowSize) {
        for (j in 0 until columSize) {
            val set = matrix[i][j]
            if (set == 0) {
                rowMark.add(i)
                break
            }
        }
    }

    println(rowMark.toString())

    val columMark = mutableListOf<Int>()


    for (i in 0 until columSize) {
        for (j in 0 until rowSize) {
            val set = matrix[j][i]
            if (set == 0) {
                columMark.add(i)
                break
            }
        }
    }
    println(columMark.toString())

    for (i in rowMark) {
        for (j in 0 until columSize) {
            matrix[i][j] = 0
        }
    }

    for (i in columMark) {
        for (j in 0 until rowSize) {
            matrix[j][i] = 0
        }
    }
}