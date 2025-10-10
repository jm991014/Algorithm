class Solution {
    fun solution(s: String): String = s.length.let { if (it % 2 != 0) "${s[it / 2]}" else "${s[it / 2 - 1]}${s[it / 2]}"}
}