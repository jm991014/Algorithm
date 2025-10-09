class Solution {
    fun solution(lines: Array<IntArray>): Int {
        val result = IntArray(201)
        
        lines.forEach { line ->
            (line[0] until line[1]).map { result[it + 100] += 1 }
        }
        return result.count { it > 1 }
    }
}