class Solution {
    fun solution(l: Int, r: Int): IntArray {
        val arr = (l..r).filter {
            it.toString().all { char -> char == '0' || char == '5' }
        }
        return if (arr.isEmpty()) { intArrayOf(-1)} else { arr.toIntArray() }
    }
}