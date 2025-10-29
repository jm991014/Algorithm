class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        
        val wantMap = mutableMapOf<String, Int>()
        
        want.forEachIndexed { i, item ->
            wantMap.put(item, number[i])
        }
        
        for (i in 0..discount.size - 10) {
            val discounted = discount.slice(i until i + 10).groupingBy { it }.eachCount()
            
            if (discounted == wantMap) answer++
        }
        return answer
    }
}