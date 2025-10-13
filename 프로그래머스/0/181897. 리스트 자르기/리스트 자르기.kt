class Solution {
    fun solution(n: Int, slicer: IntArray, num_list: IntArray): IntArray = when (n) {
        1 -> num_list.sliceArray(0..slicer[1])
        2 -> num_list.sliceArray(slicer[0]..num_list.lastIndex)
        3 -> num_list.sliceArray(slicer[0]..slicer[1])
        else -> (slicer[0]..slicer[1] step slicer[2]).map { num_list[it] }.toIntArray()
    }
}