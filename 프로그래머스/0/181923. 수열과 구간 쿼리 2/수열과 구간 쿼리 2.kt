class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf()
        queries.forEach {
            var large: Int = 1000000
            for(i in it[0]..it[1]) {
                if(arr[i] > it[2] && arr[i] < large && it[0] <= arr[i]) {
                    large = arr[i]
                }
            }
            if(large == 1000000) answer += -1 
            else answer += large
            
        }
        return answer
    }
}