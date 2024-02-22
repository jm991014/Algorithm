class Solution {
    fun solution(arr: IntArray, queries: Array<IntArray>): IntArray {
        var answer: IntArray = arr
        queries.forEach {
            for(i in it[0]..it[1]) {
                if(i % it[2] == 0) {
                    answer[i] = arr[i] + 1
                } else {
                    answer[i] = arr[i]
                }
            }
        }
        return answer
    }
}