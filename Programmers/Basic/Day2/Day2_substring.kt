class Solution {
    fun solution(my_string: String, overwrite_string: String, s: Int): String {
        var answer: String = ""
        var my_sub = my_string.toMutableList()
        val over_sub = overwrite_string.toMutableList()
        for(i in 0 until over_sub.size) {
            my_sub[s+i] = over_sub[i]
        }
        answer = my_sub.joinToString("")
        return answer
    }
}

// fun solution(myString: String, overwriteString: String, s: Int): String =
//     myString.replaceRange(s, s + overwriteString.length, overwriteString)

// replaceRange(startindex, endindex, replaceChar) 함수를 사용하면 더 간단하다.


// 테스트용 코드
// fun main(args: Array<String>) {
//     Solution().solution("HelloWorld", "MANN", 5)
// }
