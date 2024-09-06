class Solution {
    fun solution(my_string: String) = my_string.replace("a|e|i|o|u".toRegex(), "")
}