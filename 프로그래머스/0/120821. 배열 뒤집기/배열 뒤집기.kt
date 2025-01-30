class Solution {
    fun solution(num_list: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        for (i in num_list.size - 1 downTo 0) answer += num_list[i]
        return answer
    }
}