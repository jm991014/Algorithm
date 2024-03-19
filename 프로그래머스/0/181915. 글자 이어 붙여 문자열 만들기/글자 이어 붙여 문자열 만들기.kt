class Solution {
    fun solution(my_string: String, index_list: IntArray): String {
        var answer: String = ""
        for(i in 0..index_list.size-1) {
            answer += my_string[index_list[i]]
        }
        return answer
    }
}