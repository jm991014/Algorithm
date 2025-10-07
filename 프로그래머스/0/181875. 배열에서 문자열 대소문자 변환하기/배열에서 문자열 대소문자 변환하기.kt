class Solution {
    fun solution(strArr: Array<String>): Array<String> = strArr.mapIndexed { i, str -> if (i % 2 == 1) str.uppercase() else str.lowercase() }.toTypedArray()
}