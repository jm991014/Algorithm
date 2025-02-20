class Solution {
    fun solution(array: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        val max = array.maxOf { it }
        answer += max
        answer += array.indexOf(max)
        return answer
    }
}