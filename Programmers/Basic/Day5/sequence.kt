// 등차수열 특정 항만 더하기

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


// filterIndexed에 람다식 사용
// fun solution(a: Int, d: Int, included: BooleanArray): Int {
//         return List(included.size) { a + d * it }
//             .filterIndexed{ idx, value -> included[idx] }
//             .sum()
//     }

fun main() {
    val included = booleanArrayOf(false, false, false, true, false, false, false)
    print(Solution().solution(7, 1, included))
}