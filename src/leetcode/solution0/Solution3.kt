package leetcode.solution0

import leetcode.eq

class Solution3 {
    class Solution1 {
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

    class Solution2 {
        fun lengthOfLongestSubstring(s: String): Int {
            var max = 0
            var k = 0
            val map = mutableMapOf<Char, Int>()
            for ((i, ch) in s.withIndex()) {
                val value = map[ch]
                if (value != null) {
                    if (i - k > value) {
                        ++k
                    } else {
                        k = i - value
                    }
                } else {
                    ++k
                }
                max = max.coerceAtLeast(k)
                map[ch] = i
            }
            return max
        }
    }
}

private val cases = mapOf(
        "abcabcbb" to 3,
        "bbbbb" to 1,
        "pwwkew" to 3,
        "" to 0,
        " " to 1,
        "  " to 1,
        "ab" to 2,
        "abc" to 3,
        "aab" to 2,
        "cdd" to 2
)

fun main() {
    println("solution 1=========")
    for ((input, expected) in cases) {
        print("\"$input\" => ")
        Solution3.Solution1().lengthOfLongestSubstring(input) eq expected
    }
    println("solution 2=========")
    for ((input, expected) in cases) {
        print("\"$input\" => ")
        Solution3.Solution2().lengthOfLongestSubstring(input) eq expected
    }
}
