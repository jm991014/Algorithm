class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String = my_string.toCharArray().apply {
        val tmp = this[num1]
        this[num1] = this[num2]
        this[num2] = tmp
    }.joinToString("")
}