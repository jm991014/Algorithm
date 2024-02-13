class Solution {
    fun solution(num1: Int, num2: Int): Int {
        val anum1 = num1.toDouble()
        val anum2 = num2.toDouble()
        return ((anum1 / anum2) * 1000).toInt()
    }
}

// num1 * 1000 / num2 이러면 toDouble을 하지 않아도 됨

fun main() {
    print(Solution().solution(7, 3))
}