class Solution {
    fun solution(num_list: IntArray, n: Int) = num_list.filterIndexed { i, _ -> i % n == 0 }
}