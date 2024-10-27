import kotlin.math.sqrt

class Solution {
    fun solution(n: Int, k: Int): Int {
        val numbers = n.toString(k)
            .split("0")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
        
        return numbers.count { isPrime(it) }
    }
    
    fun isPrime(num: Long): Boolean {
        if(num < 2) return false
        
        for(i in 2..sqrt(num.toDouble()).toLong()) {
            if (num % i == 0L) return false
        }
        return true
    }
}