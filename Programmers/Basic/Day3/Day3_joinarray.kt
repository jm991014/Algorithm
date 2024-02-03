// Array에 담긴 문자를 하나의 String으로 합치기
class Solution {
    fun solution(arr: Array<String>): String {
        var answer: String = ""
        for(i in arr.indices) {
            answer += arr[i]
        }
        return answer
    }
}

// arr.forEach { answer += it } 혹은,
// arr.joinToString("")

// fun main() {
//     val arr = arrayOf("a", "b", "c")
//     var ans = Solution().solution(arr)
//     print(ans)
// }