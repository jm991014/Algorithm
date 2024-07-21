class Solution {
    fun solution(numbers: IntArray): Double {
        var answer: Double = 0.0
        numbers.forEach { answer += it }
        return answer / numbers.size
    }
}