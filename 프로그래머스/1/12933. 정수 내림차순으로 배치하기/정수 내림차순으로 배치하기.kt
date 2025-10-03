class Solution {
    fun solution(n: Long) = n.toString().map { it.digitToInt() }.sortedDescending().joinToString("").toLong()
}