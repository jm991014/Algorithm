class Solution {
    fun solution(strlist: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        strlist.forEach { 
            answer += it.length
        }
        return answer
    }
}