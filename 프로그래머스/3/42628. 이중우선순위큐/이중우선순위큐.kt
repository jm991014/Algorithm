class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        operations.forEach {
            if(it.contains('I')) {
                answer.add(it.substring(2).toInt())
                answer.sortDescending()
            } else if(it.contains('D') && answer.isNotEmpty()) {
                if(it.contains('-')) answer.removeLast()
                else answer.removeFirst()
            }
        }
        var ans = intArrayOf()
        if(answer.isEmpty()) {
            ans += 0
            ans += 0
        } else {
            ans += answer[0]
            ans += answer[answer.size - 1]
        }
        return ans
    }
}