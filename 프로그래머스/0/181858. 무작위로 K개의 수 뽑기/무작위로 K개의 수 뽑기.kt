class Solution {
    fun solution(arr: IntArray, k: Int): IntArray = arr.distinct().let {
        if (it.size >= k) it.slice(0 until k)
        else it + List(k - it.size) { -1 }
    }.toIntArray()
}