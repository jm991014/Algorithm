class Solution {
    fun solution(my_string: String, n: Int): String {
        var answer: String = ""
        my_string.forEach { char ->
            repeat(n) {
                answer += char
            }
        }
        return answer
    }
}