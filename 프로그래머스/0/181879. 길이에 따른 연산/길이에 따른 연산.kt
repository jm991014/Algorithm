class Solution {
    fun solution(num_list: IntArray): Int = if (num_list.size >= 11) num_list.sum() else num_list.fold(1) { acc, num -> acc * num }
}