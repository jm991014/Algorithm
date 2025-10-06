class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int = absolutes.mapIndexed { i, n -> if (signs[i]) n else -n }.sum()
}