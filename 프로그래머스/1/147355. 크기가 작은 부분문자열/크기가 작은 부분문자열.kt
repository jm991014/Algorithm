class Solution {
    fun solution(t: String, p: String): Int = t.windowed(p.length).count { it.toLong() <= p.toLong() }
}