import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int): Int {
        val isAOdd = a % 2 == 1
        val isBOdd = b % 2 == 1
        
        return when {
            isAOdd && isBOdd -> a * a + b * b
            !isAOdd && !isBOdd -> abs(a - b)
            else -> 2 * (a + b)
            
        }
    }
}