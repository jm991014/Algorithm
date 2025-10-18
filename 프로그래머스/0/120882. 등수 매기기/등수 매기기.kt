class Solution {
    fun solution(score: Array<IntArray>): IntArray = score.map { (it[0] + it[1]) / 2.0 }.let { averages -> 
        val sorted = averages.sortedDescending()
        averages.map { sorted.indexOf(it) + 1 } 
    }.toIntArray()
}