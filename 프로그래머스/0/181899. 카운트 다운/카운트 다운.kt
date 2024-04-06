class Solution {
    fun solution(start: Int, end_num: Int): IntArray {
        var answer = mutableListOf<Int>()
        for(i in end_num..start) answer.add(i)
        return answer.reversed().toIntArray()
    }
}