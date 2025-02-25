class Solution {
        fun solution(my_string: String): Int = my_string.split("[a-zA-Z]".toRegex()).fold(0) { acc, s -> if (s.isNotEmpty()) acc + s.toInt() else acc }
}