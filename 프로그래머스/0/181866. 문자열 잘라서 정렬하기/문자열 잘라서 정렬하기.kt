class Solution {
    fun solution(myString: String): Array<String> = myString.split("x").filter { it.isNotBlank() }.sorted().toTypedArray()
}