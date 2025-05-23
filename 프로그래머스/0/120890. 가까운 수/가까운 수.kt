import kotlin.math.abs

class Solution {
    fun solution(array: IntArray, n: Int): Int = array.sorted().minWithOrNull(compareBy { abs(it - n) })!!
}