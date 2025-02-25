class Solution {
    fun solution(n: Int): Int = (1..n).filter { !it.isPrime() }.size
    
    fun Int.isPrime() : Boolean {
        for (i in 2 until this) {
            if (this % i == 0) return false
        }
        return true
    }
}