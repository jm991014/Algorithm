// it이나 람다식 조금 더 공부해야할 듯
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
// import kotlin.math.pow

// class Solution {
//     fun solution(nums: IntArray): Int =
//         if (nums.fold(1) {mul, num -> mul * num} < nums.sum().toDouble().pow(2)) 1 else 0
// }

fun main() {
    print(Solution().solution(intArrayOf(3, 4, 5, 2, 1)))
}