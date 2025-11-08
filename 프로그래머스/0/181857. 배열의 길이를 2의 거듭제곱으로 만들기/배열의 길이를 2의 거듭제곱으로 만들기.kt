class Solution {
    fun solution(arr: IntArray): IntArray = arr.copyOf(generateSequence(1) { it * 2 }.first { it >= arr.size })
}