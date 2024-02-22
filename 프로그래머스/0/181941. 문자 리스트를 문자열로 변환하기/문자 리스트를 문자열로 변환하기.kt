class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = ""
        for(i in arr.indices) {
            answer += arr[i]
        }
        return answer
    }
}