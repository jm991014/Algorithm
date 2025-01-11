class Solution {
    fun solution(p: String): String {
        if (p.isEmpty()) return p

        val index = getIndex(p)
        val u = p.substring(0, index + 1)
        val v = p.substring(index + 1)

        return if (isCorrect(u)) u + solution(v)
        else {
            val answer = StringBuilder("(")
                .append(solution(v))
                .append(")")
            u.substring(1, u.length - 1).forEach {
                answer.append(if (it == '(') ")" else "(")
            }
            answer.toString()
        }
    }

    private fun getIndex(p: String): Int {
        var count = 0
        var idx = 0
        for (i in p.indices) {
            if (p[i] == '(') count += 1 else count -= 1
            if (count == 0) {
                idx = i
                break
            }
        }
        return idx
    }
     private fun isCorrect(p: String): Boolean {
        var count = 0
        for(i in p.indices){
            if(p[i] == '(') count += 1 else count -= 1
            if(count < 0) return false
        }
        return true
    }
}