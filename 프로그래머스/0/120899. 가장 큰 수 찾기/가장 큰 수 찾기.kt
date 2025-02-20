class Solution {
    fun solution(array: IntArray): IntArray = array.withIndex().maxOf { it.value }.let { 
        intArrayOf(it, array.indexOf(it))
    }
}