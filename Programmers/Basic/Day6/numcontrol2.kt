class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        for(i in 0 until numLog.size-1) {
            var log = numLog[i+1] - numLog[i]
            when(log) {
                1 -> answer += 'w'
                -1 -> answer += 's'
                10 -> answer += 'd'
                -10 -> answer += 'a'
            }
        }
        return answer
    }
}
// return (1..numLog.lastIndex).map {
//             when (numLog[it] - numLog[it-1]) {
//                 1 -> 'w'
//                 -1 -> 's'
//                 10 -> 'd'
//                 else -> 'a'
//             }
//         }.joinToString("")

fun main() {
    print(Solution().solution(intArrayOf(0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1)))
}