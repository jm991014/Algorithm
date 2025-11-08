class Solution {
    fun solution(n: Int): Array<IntArray> = (0 until n).map { row ->
        IntArray(n) { if (row == it) 1 else 0 }
    }.toTypedArray()
}