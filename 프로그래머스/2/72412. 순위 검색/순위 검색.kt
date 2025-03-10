class Solution {
    private val map = mutableMapOf<String, MutableList<Int>>()

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val answer = IntArray(query.size)

        info.forEach {
            val (lang, position, rank, food, score) = it.split(" ")
            val infoArr= Array(4) { Array(2) {"-"} }.apply {
                this[0][0] = lang
                this[1][0] = position
                this[2][0] = rank
                this[3][0] = food
            }
            getCombination(0, infoArr, score.toInt(), "")
        }
        map.forEach { it.value.sort() }

        query.forEachIndexed { idx, q ->
            val (key, score) = q.replace("and ", "").split(" ").let { it.take(4).joinToString("") to it[4].toInt() }
            val values = map.getOrDefault(key, mutableListOf())
            if (map.containsKey(key)) answer[idx] = values.lowerBound(score)
        }
        return answer
    }

    fun getCombination(depth: Int, infoArr: Array<Array<String>>, score: Int, combination: String) {
        if (depth == 4) {
            val current = map.getOrDefault(combination, mutableListOf())
            current.add(score)
            map[combination] = current
            return
        }
        getCombination(depth + 1, infoArr, score, combination + infoArr[depth][0])
        getCombination(depth + 1, infoArr, score, combination + infoArr[depth][1])
    }

    fun List<Int>.lowerBound(target: Int): Int {
        var low = 0
        var high = this.size
        while (low < high) {
            val mid = (low + high) / 2
            if (target <= this[mid]) high = mid
            else low = mid + 1
        }
        return this.size - low
    }
}