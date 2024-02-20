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
// 람다식에 더 익숙해져야할 듯
// queries.forEach { (first, second) -> 
//         arr[first] = arr[second].also { arr[second] = arr[first] }
//     }

fun main() {
    Solution().solution(intArrayOf(0,1,2,3,4), arrayOf(intArrayOf(0,3), intArrayOf(1,2), intArrayOf(1,4)))
}