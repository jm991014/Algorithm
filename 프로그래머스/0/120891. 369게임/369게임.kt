class Solution {
    fun solution(order: Int): Int = order.toString().count { it != '0' && it.digitToInt() % 3 == 0 }
}