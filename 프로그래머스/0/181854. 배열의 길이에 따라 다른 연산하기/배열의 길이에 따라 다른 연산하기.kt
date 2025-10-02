class Solution {
    fun solution(arr: IntArray, n: Int) = if (arr.size % 2 == 1) arr.mapIndexed { idx, num -> if (idx % 2 == 0) num + n else num } else arr.mapIndexed { idx, num -> if (idx % 2 == 1) num + n else num }
}