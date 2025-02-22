class Solution {
    fun solution(s: String): Int {
        var answer = 0
        val result = mutableListOf<String>()
        var min = s.length

        for (length in 1..s.length) {
            var count = 1
            val group = s.windowed(length, length).toMutableList()
            if (s.length % length != 0) group.add((s.takeLast(s.length % length)))
            for (i in 0 until group.size - 1) {
                if (group[i] == group[i + 1]) count++
                else {
                    if (count > 1) result.add("$count${group[i - 1]}")
                    else result.add(group[i])
                    count = 1
                }
            }
            if (count > 1) result.add("$count${group.last()}")
            else result.add(group.last())
            min = min.coerceAtMost(result.joinToString("").length)
            result.clear()
        }
        return min
    }
}