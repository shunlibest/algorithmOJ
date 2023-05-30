package com.hash


fun main() {
    val nums = Array(9) { i: Int -> CharArray(9) }

    nums[0] = charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.')
    nums[1] = charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.')
    nums[2] = charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.')
    nums[3] = charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3')
    nums[4] = charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1')
    nums[5] = charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6')
    nums[6] = charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.')
    nums[7] = charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5')
    nums[8] = charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')


    val value = isValidSudoku(nums)
    println(value);
}


fun isValidSudoku(board: Array<CharArray>): Boolean {
    //行
    val set = HashSet<Char>()
    board.forEach {
        set.clear()
        it.forEach { item ->
            if (set.contains(item)) {
                return false
            } else {
                if (item != '.') {
                    set.add(item)
                }
            }
        }
    }

    //列

    for (i in 0..8) {
        set.clear()
        board.forEach {
            val item = it[i]
            if (set.contains(item)) {
                return false
            } else {
                if (item != '.') {
                    set.add(item)
                }
            }
        }
    }

    for (i in 0..8 step 3) {
        for (j in 0..8 step 3) {
            set.clear()

            for (x in 0..2) {
                for (y in 0..2) {
                    val item = board[i + x][j + y]
                    if (set.contains(item)) {
                        return false
                    } else {
                        if (item != '.') {
                            set.add(item)
                        }
                    }
                }
            }
        }
    }
    return true
}