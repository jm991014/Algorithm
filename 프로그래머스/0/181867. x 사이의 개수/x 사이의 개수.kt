class Solution {
    fun solution(myString: String): IntArray = myString.split("x").map { it.length }.toIntArray()
}