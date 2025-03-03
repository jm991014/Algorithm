class Solution {
    fun solution(n: Int): Int = n / gcd(6, n)
    
    fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}