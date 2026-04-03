class Solution {
    fun solution(arr: IntArray): IntArray {
        var stk = mutableListOf<Int>()
        (0 until arr.size).forEach { i ->
            if (stk.isEmpty()) {
                stk.add(arr[i])
            } else {
                if (stk.last() == arr[i]) stk.removeLast()
                else stk.add(arr[i])
            }
        }
        return if (stk.isEmpty()) intArrayOf(-1) else stk.toIntArray()
    }
}