class Solution {
    fun solution(my_string: String): Array<String> = (my_string.length - 1 downTo 0).map { my_string.substring(it) }.sorted().toTypedArray()
}