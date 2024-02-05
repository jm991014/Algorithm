// 공배수라면 1 아니면 0
class Solution {
    fun solution(number: Int, n: Int, m: Int): Int {
        return if ((number % n == 0) && (number % m == 0)) 1 else 0
    }
}

fun main() {
    print(Solution().solution(60, 2, 3))
}