class Solution {
    fun solution(box: IntArray, n: Int): Int = box.fold(1) { total, dice -> total * (dice / n) }
}