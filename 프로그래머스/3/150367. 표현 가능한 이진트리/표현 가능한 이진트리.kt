import kotlin.math.*

class Solution {
    fun solution(numbers: LongArray): IntArray = numbers.map { number ->
        val binary = number.toString(2).let {
            val n = ceil(log2(it.length + 1.0)).toInt()
            val totalLength = (1 shl n) - 1
            "0".repeat(totalLength - it.length) + it
        }
        
        if (isNumberValid(binary)) 1 else 0
    }.toIntArray()
    
    fun isNumberValid(binary: String): Boolean {
        if (binary.length == 1) return true

        val mid = binary.length / 2
        val left = binary.take(mid)
        val right = binary.takeLast(mid)

        if (binary[mid] == '0') {
            return binary.all { it == '0' }
        }

        return isNumberValid(left) && isNumberValid(right)
    }
}