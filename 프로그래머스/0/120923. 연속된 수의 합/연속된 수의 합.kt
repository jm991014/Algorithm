class Solution {
    fun solution(num: Int, total: Int): IntArray = (-1000..1000).windowed(num).filter {
        it.sum() == total
    }.flatMap { it }.toIntArray()
}