class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        val len1 = arr1.size
        val len2 = arr2.size
        val sum1 = arr1.sum()
        val sum2 = arr2.sum()
        
        return when {
            len1 > len2 -> 1
            len1 < len2 -> -1
            else -> when {
                sum1 > sum2 -> 1
                sum1 < sum2 -> -1
                else -> 0
            }
        }
    }
}