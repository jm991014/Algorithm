class Solution {
    fun solution(sides: IntArray): Int {
        val max = sides.maxOf { it }
        val min = sides.minOf { it }
        return (1 until sides.sum()).filter { (it < sides.sum() && it > max) || (it + min > max) }.count()
    }
}