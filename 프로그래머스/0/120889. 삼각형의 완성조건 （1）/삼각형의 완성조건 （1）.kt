class Solution {
    fun solution(sides: IntArray): Int = with(sides.sorted()) {
        if (take(2).sum() > last()) 1 else 2
    }
}