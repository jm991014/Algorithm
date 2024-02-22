class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var a = n
        if(n % 2 == 1){
            while(a > 0) {
                answer += a
                a -= 2
            }
        }else {
            while(a > 0) {
                answer += a * a
                a -= 2
            }
        }
        return answer
    }
}