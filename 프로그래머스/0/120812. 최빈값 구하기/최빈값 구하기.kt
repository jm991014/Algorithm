class Solution {
    fun solution(array: IntArray): Int = array.groupBy { it }.mapValues { it.value.size }.let { freqMap ->
        freqMap.filterValues { it == freqMap.maxOf { it.value } }.keys.let {
            if (it.size > 1) -1 else it.first()
        }
    }
}