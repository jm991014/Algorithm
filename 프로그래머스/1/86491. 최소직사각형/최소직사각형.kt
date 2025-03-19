class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var width = 0
        var height = 0
        sizes.forEach { it.sort() }
        sizes.forEach { width = width.coerceAtLeast(it[0]) }
        sizes.forEach { height = height.coerceAtLeast(it[1]) }
        return (width * height)
    }
}