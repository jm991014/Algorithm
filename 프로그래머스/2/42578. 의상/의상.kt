class Solution {
    fun solution(clothes: Array<Array<String>>): Int =
        clothes
            .groupBy({ it[1] }, { it[0] })
            .values
            .fold(1) { acc, items -> acc * (items.size + 1) } - 1
}