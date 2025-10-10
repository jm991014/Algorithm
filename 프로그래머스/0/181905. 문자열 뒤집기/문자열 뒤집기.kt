class Solution {
    fun solution(my_string: String, s: Int, e: Int): String = my_string.replaceRange(s..e, my_string.substring(s, e + 1).reversed())  
}