class Solution {
    fun solution(arr: IntArray, flag: BooleanArray): IntArray = mutableListOf<Int>().apply {
        flag.mapIndexed { i, f ->
            if (f) repeat(arr[i] * 2) { add(arr[i]) }
            else repeat(arr[i]) { removeLast() }
        }
    }.toIntArray()
}