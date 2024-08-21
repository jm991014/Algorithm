class Solution {
    fun solution(s: String): String = s.toLowerCase().split(" ").joinToString(" ") { it.replaceFirstChar { it.uppercase() } }
}