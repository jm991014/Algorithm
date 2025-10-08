class Solution {
    fun solution(numbers: IntArray, n: Int): Int = numbers.scan(0) { acc, num -> acc + num }.first { it > n }
}