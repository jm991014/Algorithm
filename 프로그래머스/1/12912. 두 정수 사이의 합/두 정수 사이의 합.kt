import kotlin.math.*
class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        for(i in min(a, b)..max(a, b)) answer += i.toLong()
        return answer
    }
}