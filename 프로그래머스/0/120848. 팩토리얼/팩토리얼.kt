class Solution {
    fun solution(n: Int): Int {
        var factorial = 1
        for (i in 1..10) {
            factorial *= i
            if (n < factorial) return i - 1
        }
        return 10
    }
}