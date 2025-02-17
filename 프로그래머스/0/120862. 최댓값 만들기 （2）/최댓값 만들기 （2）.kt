class Solution {
    fun solution(numbers: IntArray): Int {
        val sorted = numbers.sorted()
        return maxOf(sorted[0] * sorted[1], sorted[sorted.size - 1] * sorted[sorted.size - 2])
    }
}