class Solution {
    fun solution(s: String): String {
        val arr = s.split(" ").map { it.toInt() }
        return "${arr.minOf{it}} ${arr.maxOf{it}}"
    }
}