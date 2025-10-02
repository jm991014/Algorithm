class Solution {
    fun solution(num_list: IntArray): Int {
        num_list.forEachIndexed { index, num ->
            if (num < 0) return index
        }
        return -1
    }
}