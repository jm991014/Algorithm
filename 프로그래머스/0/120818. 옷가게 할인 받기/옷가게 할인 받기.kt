class Solution {
    fun solution(price: Int) = when(price) {
        in 10 until 100000 -> price
        in 100000 until 300000 -> (0.95 * price).toInt()
        in 300000 until 500000 -> (0.9 * price).toInt()
        else -> (0.8 * price).toInt()
    }
}