class Solution {
    fun solution(n: Int): Int {
        val arr = IntArray(n + 1) { it }
        for (i in 2 .. n) {
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567
        }
        return arr[n]
    }
}