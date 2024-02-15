class Solution {
    fun solution(n: Int, control: String): Int {
        var answer: Int = 0
        control.forEach {
            when(it) {
                'w' -> answer += 1
                's' -> answer -= 1
                'd' -> answer += 10
                'a' -> answer -= 10
            }
        }
        answer += n
        return answer
    }
}

// fun solution(n: Int, control: String): Int {
//         val map = mapOf('w' to 1, 's' to -1, 'd' to 10, 'a' to -10)
//         return control.fold(n) { acc, w -> acc + map.getValue(w) }
//     }

fun main() {
    print(Solution().solution(0, "wsdawsdassw"))
}