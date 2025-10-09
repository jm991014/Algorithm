class Solution {
    fun solution(arr: IntArray): IntArray = if (arr.size == 1) intArrayOf(-1) else arr.toMutableList().apply { remove(arr.minOf { it }) }.toIntArray()
}