class Solution {
    fun solution(num_str: String): Int = num_str.sumOf { it.digitToInt() }
}