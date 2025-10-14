class Solution {
    fun solution(myStr: String): Array<String> = myStr.split("a", "b", "c").filter { it.isNotEmpty() }.let { if (it.isEmpty()) arrayOf("EMPTY") else it.toTypedArray() }
}