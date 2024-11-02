class Solution {
    fun solution(s: String): IntArray {
        var zeros = s.count { it == '0' }
        var len = s.replace("0", "").length
        var count = 1
        
        while(len > 1) {
            val s2 = len.toString(2)
            zeros += s2.count { it == '0' }
            len = s2.replace("0", "").length
            count++
        }
        return intArrayOf(count, zeros)
    }
}