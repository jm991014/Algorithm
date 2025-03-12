class Solution {
    fun solution(balls: Int, share: Int): Int = combination(balls, share)
    
    fun combination(n: Int, m: Int): Int = if (n == m || m == 0) 1 else combination(n - 1, m - 1) + combination(n - 1, m)

}