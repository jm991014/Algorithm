class Solution {
    fun solution(numbers: IntArray): String {
        var result = numbers.map { it.toString() }
            .sortedWith { a, b -> (b + a).compareTo(a + b) }
            .joinToString("")
            
        return if (result[0] == '0') "0" else result
    }
}