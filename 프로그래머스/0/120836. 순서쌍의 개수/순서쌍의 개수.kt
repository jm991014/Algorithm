class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in 1..n/2) if (n % i == 0) answer++
        return answer + 1
    }
}