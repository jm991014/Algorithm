class Solution {
    fun solution(a: Int, b: Int, flag: Boolean): Int {
        return if(flag == true) a + b else a - b
    }
}
fun main() {
    print(Solution().solution(-4, 7, false))
}
