class Solution {
    fun solution(chicken: Int): Int {
        var tmp = chicken
        var ans = 0
        while (tmp >= 10) {
            val coupon = tmp / 10
            val left = tmp % 10
            ans += coupon
            tmp = coupon + left
        }
        return ans
    }
}