class Solution {
    fun solution(a: Int, b: Int, c: Int): Int {
        var answer: Int = 0
        if(a == b && b == c && a == c) {
            answer = (a + b + c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c)
        } else if (a != b && b != c && a != c) {
            answer = (a + b + c)
        } else {
            answer = (a + b + c) * (a*a + b*b + c*c)
        }
        return answer
    }
}
// set화 시켜서 경우의 수에 따라 계산
// val set = intArrayOf(a, b, c).toSet()
//         return when (set.size) {
//             3 -> a + b + c
//             2 -> (a + b + c) * (a * a + b * b + c * c)
//             1 -> (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
//             else -> -1
//         }

fun main() {
    print(Solution().solution(5, 3, 3))
}