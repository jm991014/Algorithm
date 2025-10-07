class Solution {
    fun solution(s: String): String = s.split(" ").joinToString(" ") {
        it.mapIndexed { i, c -> if (i % 2 == 0) c.uppercase() else c.lowercase() }.joinToString("")
    }
}