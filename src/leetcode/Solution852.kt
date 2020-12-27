package leetcode

class Solution852 {
    class SolutionLinear {
        fun peakIndexInMountainArray(arr: IntArray): Int {
            var i = 0
            while (arr[i] < arr[i + 1]) {
                ++i
            }
            return i
        }
    }

    class SolutionBinarySearch {
        fun peakIndexInMountainArray(arr: IntArray): Int {
            var a = 0
            var b = arr.size - 1
            while (b - a > 1) {
                val m = (a + b) / 2
                val slope = arr[m - 1] - arr[m]
                if (slope < 0) {
                    a = m
                } else {
                    // slope > 0 by conditions
                    b = m
                }
            }
            return a
        }
    }
}

fun main() {
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[0,1,0]".toIntArray()
    ) eq 1
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[0,2,1,0]".toIntArray()
    ) eq 1
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[0,10,5,2]".toIntArray()
    ) eq 1
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[3,4,5,1]".toIntArray()
    ) eq 2
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[24,69,100,99,79,78,67,36,26,19]".toIntArray()
    ) eq 2
    Solution852.SolutionBinarySearch().peakIndexInMountainArray(
            "[18,29,38,59,98,100,99,98,90]".toIntArray()
    ) eq 5
}
