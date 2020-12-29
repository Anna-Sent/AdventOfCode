package leetcode.solution14

class Solution1470 {
    class Solution {
        fun shuffle(nums: IntArray, n: Int): IntArray {
            val result = IntArray(nums.size)
            var i = 0
            var j = 0
            while (i < 2 * n) {
                result[i] = nums[j]
                result[i + 1] = nums[n + j]
                i += 2
                ++j
            }
            return result
        }
    }
}
