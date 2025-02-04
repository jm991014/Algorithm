class Solution {
    fun solution(numbers: IntArray) = numbers.sortedDescending().take(2).reduce { a, b -> a * b }
}