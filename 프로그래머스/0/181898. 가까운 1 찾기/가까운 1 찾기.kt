class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        var answer: Int = -1
        for(i in arr.indices) {
            if(arr[i] == 1 && i >= idx) {
                answer = i
                break
            }
        }
        return answer
    }
}