package leetcode.solution14

class Solution1480 {
    class Solution {
        fun runningSum(nums: IntArray): IntArray {
            val result = IntArray(nums.size)
            var sum = 0
            for ((i, num) in nums.withIndex()) {
                sum += nums[i]
                result[i] = sum
            }
            return result
        }
    }
}
