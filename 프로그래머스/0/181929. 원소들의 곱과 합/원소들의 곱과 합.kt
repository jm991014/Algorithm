class Solution {
    fun solution(num_list: IntArray): Int {
        var sum: Int = 0
        var mul: Int = 1
        for(i in num_list.indices) {
            mul *= num_list[i]
            sum += num_list[i]
        }
        return if(mul < (sum * sum)) 1 else 0 
    }
}