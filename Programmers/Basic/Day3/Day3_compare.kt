// 입력받은 두 수 중 연결 vs 2 * a * b 큰거 반환
import kotlin.math.max

class Solution {
    fun solution(a: Int, b: Int): Int {
            return max("$a$b".toInt(), (2*a*b))
    }
}


fun main() {
    print(Solution().solution(91, 2))
}