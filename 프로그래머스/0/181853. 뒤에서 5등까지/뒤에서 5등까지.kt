class Solution {
    fun solution(num_list: IntArray): IntArray = num_list.sorted().dropLast(num_list.size - 5).toIntArray()
}