package leetcode.solution16

class Solution1662 {
    class Solution {
        fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
            return word1.joinToString("") == word2.joinToString("")
        }
    }
}
