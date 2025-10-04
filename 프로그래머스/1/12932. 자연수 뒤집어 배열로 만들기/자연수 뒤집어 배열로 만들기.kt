class Solution {
    fun solution(n: Long): IntArray = n.toString().map { it.digitToInt() }.reversed().toIntArray()
}