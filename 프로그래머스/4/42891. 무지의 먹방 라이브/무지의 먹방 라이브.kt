class Solution {
    fun solution(food_times: IntArray, k: Long): Int {
        val size = food_times.size
        val sorted = food_times.sortedArray()
        var eaten = 0L
        var time = 0L

        sorted.forEachIndexed { i, sorted ->
            if (time + (size - i) * (sorted - eaten) > k) {
                val moves = (k - time) % (size - i)
                var tmp = 0L
                
                food_times.forEachIndexed { j, food ->
                    if (food - eaten <= 0) return@forEachIndexed
                    
                    if (tmp++ >= moves) return j + 1
                }
            }
            
            time += (size - i) * (sorted - eaten)
            eaten = sorted.toLong()
        }
        
        return -1
    }
}
