class Solution {
    fun solution(arr: IntArray): IntArray = arr.dropWhile { it != 2 }.dropLastWhile { it != 2 }.let { if (it.isEmpty()) intArrayOf(-1) else it.toIntArray() }
}