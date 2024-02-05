// 홀수는 n 이하 홀수 다 더하기, 짝수면 n 이하 짝수 제곱 더하기
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
// fun solution(n: Int) = if (n % 2 != 0) (1..n step 2).sum() else (2..n step 2).map { it.toDouble().pow(2.0) }.sum().toInt()
// or
// return if(n % 2 == 0) {
//     (n downTo 1 step 2).sumOf { it * it }
// } else {
//     (n downTo 1 step 2).sum()
// }

fun main() {
    print(Solution().solution(10))
}