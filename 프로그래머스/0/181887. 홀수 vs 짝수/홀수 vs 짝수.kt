import kotlin.math.*

class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        var even: Int = 0
        var odd: Int = 0
        for(i in num_list.indices) {
            if(i % 2 == 0) odd += num_list[i]
            else even += num_list[i]
        }
        answer = max(even, odd)
        return answer
    }
}