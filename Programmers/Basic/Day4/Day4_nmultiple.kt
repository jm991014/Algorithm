// 배수라면 1, 아니면 0을 return
class Solution {
    fun solution(num: Int, n: Int): Int {
        return if (num % n == 0) 1 else 0
    }
}

fun main() {
    print(Solution().solution(98, 2))
}