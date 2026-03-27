class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray = arr.apply {
        queries.map { query ->
            for (i in query[0]..query[1]) {
                this[i]++
            }
        }
    }
}