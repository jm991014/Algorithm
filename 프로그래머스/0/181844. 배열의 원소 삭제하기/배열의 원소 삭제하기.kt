class Solution {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray = arr.filter { !delete_list.contains(it) }.toIntArray()
}