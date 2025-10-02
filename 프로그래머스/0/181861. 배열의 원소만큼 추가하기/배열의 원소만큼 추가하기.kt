class Solution {
    fun solution(arr: IntArray): IntArray = mutableListOf<Int>().apply {
        arr.forEach { n ->
            repeat(n) {
                this.add(n)
            }
        }
    }.toIntArray()
}