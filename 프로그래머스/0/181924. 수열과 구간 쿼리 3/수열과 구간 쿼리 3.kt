class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        queries.forEach {
            var tmp: Int = arr[it[0]]
            arr[it[0]] = arr[it[1]]
            arr[it[1]] = tmp
        }
        return arr
    }
}