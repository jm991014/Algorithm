class Solution {
    fun solution(str_list: Array<String>): Array<String> = str_list.indexOfFirst { it == "l" || it == "r" }.let { idx ->
        when {
            idx == -1 -> emptyArray()
            str_list[idx] == "l" -> str_list.sliceArray(0 until idx)
            else -> str_list.sliceArray(idx + 1 until str_list.size)
        }
    }
}