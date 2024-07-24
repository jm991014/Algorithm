class Solution {
    fun solution(n_str: String): String {
        var answer: String = ""
        for(i in 0..n_str.length-1) {
            if(n_str[i] != '0') {
                answer = n_str.substring(i)
                break
            }  
        }
        return answer
    }
}