class Solution {
    fun solution(arr: IntArray, divisor: Int): IntArray = arr.filter { it % divisor == 0 }.sorted().let { if (it.isEmpty()) intArrayOf(-1) else it.toIntArray() }
}