class Solution {
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val denom = denom1 * denom2
        val numer = (numer1 * denom2) + (numer2 * denom1)
        var gcd = GCD(denom, numer)
        
        answer += numer / gcd
        answer += denom / gcd
        
        return answer
    }
    fun GCD(numer1: Int, numer2: Int): Int {
        var r = numer1 % numer2
        if (r == 0) return numer2
        else return GCD(numer2, r)
    }
}
