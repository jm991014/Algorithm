class Solution {
    fun solution(spell: Array<String>, dic: Array<String>): Int = if (dic.any { it.toSet().containsAll(spell.joinToString("").toSet()) }) 1 else 2
}