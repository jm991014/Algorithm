class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        targets.forEach { target ->
            if (target.any { char -> keymap.all { key -> !key.contains(char) }}) {
                answer += -1
                return@forEach
            }
            var count = 0
            for (i in target) count += minIndex(keymap, i) + 1
            answer += count
        }
        return answer
    }
    
    fun minIndex(keymap: Array<String>, target: Char): Int {
        var min = 101
        keymap.forEach { key ->
            if(key.contains(target)) min = min.coerceAtMost(key.indexOf(target))
        }
        return min
    }
}