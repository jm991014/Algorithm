class Solution {
    fun solution(money: Int): IntArray {
        var answer: IntArray = intArrayOf()
        answer += money / 5500
        answer += money % 5500
        return answer
    }
}