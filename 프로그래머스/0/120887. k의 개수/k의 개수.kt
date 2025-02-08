class Solution {
    fun solution(i: Int, j: Int, k: Int): Int = 
    (i..j).sumOf { num -> num.toString().count { it == k.digitToChar() } }
}