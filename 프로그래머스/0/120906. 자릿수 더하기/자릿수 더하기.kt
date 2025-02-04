class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        n.toString().forEach { answer += it.digitToInt() }
        return answer
    }
}