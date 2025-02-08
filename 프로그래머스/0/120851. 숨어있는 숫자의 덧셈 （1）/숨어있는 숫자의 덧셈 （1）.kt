class Solution {
    fun solution(my_string: String): Int = my_string.sumOf { it.digitToIntOrNull() ?: 0 }
}