class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        var answer: String = ""
        str_list.forEach { str ->
            if(!str.contains(ex)) answer += str
        }
        return answer
    }
}