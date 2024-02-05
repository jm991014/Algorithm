// ineq, eq에 따라 수식이 참이면 1 아니면 0 반환
class Solution {
    fun solution(ineq: String, eq: String, n: Int, m: Int): Int {
        var bool: Boolean
        if(ineq == ">") {
            if(eq == "=") {
                bool = n >= m
            }else {
                bool = n > m
            }
        }else {
            if(eq == "=") {
                bool = n <= m
            }else {
                bool = n < m
            }
        }
        return if(bool == true) 1 else 0
    }
}


// val op = ineq + eq

//         when (op) {
//             "<=" -> answer = if (n <= m) 1 else 0
//             ">=" -> answer = if (n >= m) 1 else 0
//             "<!" -> answer = if (n < m) 1 else 0
//             ">!" -> answer = if (n > m) 1 else 0
//         }


fun main() {
    print(Solution().solution("<", "=", 20, 50))
}