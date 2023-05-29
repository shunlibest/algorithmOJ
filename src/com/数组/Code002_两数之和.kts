import java.util.Arrays
import java.util.Collections

//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

val nums = intArrayOf(2, 7, 11, 15)
val target = 9

val value=twoSum(nums, target)
println(Arrays.toString(value));



fun twoSum(nums: IntArray, target: Int): IntArray {
    val set = HashSet<Int>()
    nums.forEach {
        val need = target - it
        if (set.contains(need)){
            return intArrayOf(it,need)
        }
    }



    return intArrayOf()
}
