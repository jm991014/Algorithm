class Solution {
    fun solution(a: Int, d: Int, included: BooleanArray): Int {
        var answer: Int = 0
        for(i in 0 until included.size) {
            if(included[i] == true) {
                answer += (a + i * d)
            }
        }
        return answer
    }
}