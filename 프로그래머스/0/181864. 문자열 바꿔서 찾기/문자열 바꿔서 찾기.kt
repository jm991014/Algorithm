class Solution {
    fun solution(myString: String, pat: String): Int = if (myString.replace("A", "C").replace("B", "A").replace("C", "B").contains(pat)) 1 else 0
}