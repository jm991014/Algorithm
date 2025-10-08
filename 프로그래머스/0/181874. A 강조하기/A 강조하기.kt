class Solution {
    fun solution(myString: String): String = myString.map { if (it == 'a' || it == 'A') 'A' else it.lowercase() }.joinToString("")
}