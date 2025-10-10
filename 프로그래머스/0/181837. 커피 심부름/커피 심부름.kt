class Solution {
    fun solution(order: Array<String>): Int = order.fold(0) { acc, n ->
        when {
            n == "anything" || n.contains("americano") -> acc + 4500
            else -> acc + 5000
        }
    }
}