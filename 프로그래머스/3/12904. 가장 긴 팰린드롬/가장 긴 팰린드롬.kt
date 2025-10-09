class Solution {
    fun solution(s: String): Int {
        if (s.length < 2) return s.length

        var maxLength = 1

        for (i in s.indices) {
            val oddLength = expandFromCenter(s, i, i)
            maxLength = maxOf(maxLength, oddLength)

            val evenLength = expandFromCenter(s, i, i + 1)
            maxLength = maxOf(maxLength, evenLength)
        }

        return maxLength
    }

    private fun expandFromCenter(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right

        while (L >= 0 && R < s.length && s[L] == s[R]) {
            L--
            R++
        }
        return R - L - 1
    }
}