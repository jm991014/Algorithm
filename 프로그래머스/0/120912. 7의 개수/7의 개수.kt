class Solution {
    fun solution(array: IntArray): Int = array.joinToString("").count { it == '7' }
}