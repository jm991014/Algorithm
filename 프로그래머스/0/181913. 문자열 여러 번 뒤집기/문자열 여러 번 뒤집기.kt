class Solution {
    fun solution(my_string: String, queries: Array<IntArray>): String = queries.fold(my_string) { str, (s, e) ->
        str.replaceRange(s..e, str.substring(s, e + 1).reversed())
    }
}