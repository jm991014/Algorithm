class Solution {
    fun solution(num_list: IntArray): Int {
        var answer: Int = 0
        num_list.forEach {
            var newNum = it
            while (newNum != 1) {
                if (newNum % 2 == 0) newNum /= 2
                else newNum = (newNum - 1) / 2
                answer++
            }
        }
        return answer
    }
}