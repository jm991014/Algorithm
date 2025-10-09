class Solution {
    fun solution(n: Int): String = ((1..n / 2).map { "수박" } + if (n % 2 == 1) "수" else "").joinToString("")
}