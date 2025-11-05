class Solution {
    fun solution(myString: String, pat: String): String = myString.take(myString.lastIndexOf(pat) + pat.length)
}