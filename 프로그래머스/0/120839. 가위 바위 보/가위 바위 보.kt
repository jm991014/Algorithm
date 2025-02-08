class Solution {
    fun solution(rsp: String): String {
        var answer: String = ""
        rsp.forEach {
            when (it) {
                '2' -> answer += "0"
                '0' -> answer += "5"
                else -> answer += "2"
            }
        }
        return answer
    }
}