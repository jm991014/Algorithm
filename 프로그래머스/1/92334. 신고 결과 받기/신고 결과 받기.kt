class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val reportSet = report.toSet()
        val reportedCount = HashMap<String, Int>()
        val reportUser = HashMap<String, Set<String>>()

        reportSet.forEach {
            val (reporter, reported) = it.split(" ")
            reportedCount[reported] = reportedCount.getOrDefault(reported, 0) + 1
            reportUser[reporter] = reportUser.getOrDefault(reporter, emptySet()) + reported
        }

        id_list.forEachIndexed { index, id ->
            reportUser[id]?.forEach {
                if (reportedCount.getOrDefault(it, 0) >= k) {
                    answer[index]++
                }
            }
        }
        return answer
    }
}