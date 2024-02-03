// 같은 길이의 문자열을 받았을 때, 두 문자열을 번갈아가며 하나의 문자열로 합치기
class Solution {
    fun solution(str1: String, str2: String): String {
        var answer: String = ""
        for(i in 0 until str1.length) {
            answer += str1[i]
            answer += str2[i]
        }
        return answer
    }
} 

//  fun solution(str1: String, str2: String) = str1.zip(str2).joinToString("") { (a, b) -> "$a$b" }


// fun main() {
//     var ans = Solution().solution("aaaaa", "bbbbb")
//     print(ans)
// }