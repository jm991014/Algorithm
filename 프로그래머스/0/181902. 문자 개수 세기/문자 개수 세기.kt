class Solution {
    fun solution(my_string: String): IntArray = IntArray(52).apply { 
        my_string.forEach {
            when {
                it.isUpperCase() -> this[it - 'A']++
                it.isLowerCase() -> this[it - 'a' + 26]++
            }
        }
    }
}