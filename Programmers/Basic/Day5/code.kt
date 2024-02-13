// mode에 따라 return 값을 변화

class Solution {
    fun solution(code: String): String {
        var answer: String = ""
        var mode: Int = 0
        for(idx in 0 until code.length) {
            if(mode == 0) {
                if(code[idx] != '1' && idx % 2 == 0) {
                    answer += code[idx]
                }else if (code[idx] == '1') {
                    mode = 1
                }
            }else {
                if(code[idx] != '1' && idx % 2 == 1) {
                    answer += code[idx]
                }else if (code[idx] == '1') {
                    mode = 0
                }
            }
        }
        return if(answer.length > 0) answer else "EMPTY"
    }
}

// 람다식 사용
// code.forEachIndexed { i, v ->
//             if (v == '1') mode = mode xor 1
//             else if (mode == 0 && i % 2 == 0) answer += v
//             else if (mode == 1 && i % 2 != 0) answer += v
//         }


fun main() {
    print(Solution().solution("abc1abc1abc"))
}