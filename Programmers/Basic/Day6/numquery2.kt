class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        queries.forEach {
            var large: Int = 1000000
            for(i in it[0]..it[1]) {
                if(arr[i] > it[2] && arr[i] < large && it[0] < arr[i]) {
                    large = arr[i]
                }
            }
            if(large == 1000000) answer += -1 
            else answer += large
            
        }
        answer.forEach { println(it)}
        return answer
    }
}
// 이건 더 공부해봐야할 듯
// return queries.map { (s,e,k) ->
//         arr.slice(s..e).filter { it > k }.minOrNull() ?: -1
//     }.toIntArray()


fun main() {
    print(Solution().solution(intArrayOf(0, 1, 2, 4, 3), arrayOf(intArrayOf(0, 4, 2), intArrayOf(0, 3, 2), intArrayOf(0, 2, 2))))
}