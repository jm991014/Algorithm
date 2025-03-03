class Solution {
    fun solution(n: Int): Int = (6 * n / gcd(6, n)) / 6
    
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}