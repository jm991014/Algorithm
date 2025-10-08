class Solution {
    fun solution(num: Int): Int {
        var newNum = num.toLong()
        var cnt = 0
        while (cnt < 500) {
            if (newNum == 1L) return cnt
            
            if (newNum % 2 == 0L) newNum /= 2
            else newNum = (newNum * 3) + 1
            cnt++
        }
        return -1
    }
}