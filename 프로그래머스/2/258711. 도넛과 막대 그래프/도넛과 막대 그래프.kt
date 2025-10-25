class Solution {
    fun solution(edges: Array<IntArray>): IntArray {
        var answer: IntArray = IntArray(4)
        val maxVal = (edges.mapNotNull { it.maxOrNull() }.maxOrNull() ?: 0) + 1
        val inCnt = IntArray(maxVal) { 0 }
        val outCnt = IntArray(maxVal) { 0 }

        edges.forEach { (nowOut, nowIn) ->
            outCnt[nowOut]++
            inCnt[nowIn]++
        }

        for (nowNode in 1 until maxVal) {
            when {
                inCnt[nowNode] == 0 && outCnt[nowNode] >= 2 -> answer[0] = nowNode
                outCnt[nowNode] == 0 && inCnt[nowNode] > 0 -> answer[2]++
                inCnt[nowNode] >= 2 && outCnt[nowNode] == 2 -> answer[3]++
            }
        }

        if (answer[0] != 0) answer[1] = outCnt[answer[0]] - (answer[2] + answer[3])

        return answer
    }
}