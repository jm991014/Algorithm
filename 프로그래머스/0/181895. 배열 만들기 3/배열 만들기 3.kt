class Solution {
    fun solution(arr: IntArray, intervals: Array<IntArray>): IntArray = intervals.flatMap {
        arr.slice(it[0]..it[1])
    }.toIntArray()
}