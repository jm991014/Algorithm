class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray = num_list.drop(n - 1).toIntArray()
}