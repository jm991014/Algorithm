class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in n downTo 0) {
            if(i % 2 == 0) answer += i
        }
        return answer
    }
}