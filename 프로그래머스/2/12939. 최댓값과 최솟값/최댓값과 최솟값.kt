class Solution {
    fun solution(s: String): String {
        var answer = ""
        val arr = s.split(" ").map { it.toInt() }
        return "${arr.minOf{it}} ${arr.maxOf{it}}"
    }
}