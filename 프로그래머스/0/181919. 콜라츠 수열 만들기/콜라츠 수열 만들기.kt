class Solution {
    fun solution(n: Int): IntArray {
        var num = n
        var answer: IntArray = intArrayOf(num)
        while(num != 1) {
            if(num % 2 == 0) num = num / 2
            else num = 3 * num + 1
            answer += num
        }
        return answer
    }
}