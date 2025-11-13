class Solution {
    fun solution(numbers: IntArray): IntArray = numbers.indices.flatMap { i -> numbers.indices.drop(i + 1).map { j -> numbers[i] + numbers[j] } }.toSet().sorted().toIntArray()
}