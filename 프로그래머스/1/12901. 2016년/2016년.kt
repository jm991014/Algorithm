class Solution {
    fun solution(a: Int, b: Int): String {
        val months = arrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val days = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
        return days[((0 until a - 1).sumOf { months[it] } + b - 1) % 7]
    }
}