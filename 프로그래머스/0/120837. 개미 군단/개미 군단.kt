class Solution {
    fun solution(hp: Int): Int {
        var answer: Int = 0
        var tmp = hp
        while (tmp > 0) {
            when {
                tmp >= 5 -> tmp -= 5
                tmp >= 3 -> tmp -= 3
                else -> tmp -= 1
            }
            answer += 1
        }
        return answer
    }
}