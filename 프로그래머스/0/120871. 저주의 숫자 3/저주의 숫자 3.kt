class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for(i in 1..n) {
            answer += 1
            while(answer % 3 == 0 || answer % 10 == 3 
                  || answer / 10 == 3 || answer / 10 == 13) answer += 1
        }
        return answer
    }
}