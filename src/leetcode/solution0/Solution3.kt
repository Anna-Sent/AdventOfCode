package leetcode.solution0

import leetcode.eq

class Solution3 {
    class Solution {
        fun lengthOfLongestSubstring(s: String): Int {
            var max = 0
            var i = 0
            var j = 0
            val set = mutableSetOf<Char>()
            while (i < s.length - max && j < s.length) {
                if (s[j] in set) {
                    max = max.coerceAtLeast(set.size)
                    set.clear()
                    ++i
                    j = i
                } else {
                    set += s[j]
                    ++j
                }
            }
            max = max.coerceAtLeast(set.size)
            return max
        }
    }
}

fun main() {
    Solution3.Solution().lengthOfLongestSubstring("abcabcbb") eq 3
    Solution3.Solution().lengthOfLongestSubstring("bbbbb") eq 1
    Solution3.Solution().lengthOfLongestSubstring("pwwkew") eq 3
    Solution3.Solution().lengthOfLongestSubstring("") eq 0
    Solution3.Solution().lengthOfLongestSubstring(" ") eq 1
}
