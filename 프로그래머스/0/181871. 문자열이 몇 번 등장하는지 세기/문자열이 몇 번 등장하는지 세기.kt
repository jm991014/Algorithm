class Solution {
    fun solution(myString: String, pat: String): Int = myString.windowed(pat.length).count { it == pat }
}