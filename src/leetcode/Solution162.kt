package leetcode

class Solution162 {
    class Solution {
        fun findPeakElement(nums: IntArray): Int {
            for (i in 0..nums.lastIndex) {
                val current = nums[i]
                val left: Long = if (i == 0) Long.MIN_VALUE else nums[i - 1].toLong()
                val right: Long = if (i == nums.lastIndex) Long.MIN_VALUE else nums[i + 1].toLong()
                if (current > left && current > right)
                    return i
            }
            return -1
        }
    }
}

fun main() {
    Solution162.Solution().findPeakElement("[1,2,3,1]".toIntArray()) eq 2
    Solution162.Solution().findPeakElement("[1,2,1,3,5,6,4]".toIntArray()) eq 1
    Solution162.Solution().findPeakElement("[-2147483648]".toIntArray()) eq 0
}
