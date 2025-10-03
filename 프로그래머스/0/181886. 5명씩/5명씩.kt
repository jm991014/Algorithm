class Solution {
    fun solution(names: Array<String>) = names.filterIndexed { idx, name -> idx % 5 == 0 }
}