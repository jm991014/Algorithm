class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = Array<Int>(targets.size) { 0 }
        val charDict = mutableMapOf<Char, Int>()
        
        keymap.forEach { key ->
            val keyArr = key.toCharArray()
            keyArr.forEachIndexed { index, k ->
                charDict[k]?.let {
                    var min = charDict.getOrDefault(k, 0)
                    if ((index + 1) < min) {
                        charDict[k] = index + 1
                    }
                } ?: run { charDict[k] = index + 1 }
            }
        }        
        targets.forEachIndexed { index, target ->
            val targetArr = target.toCharArray()
            var count = 0
            
            for (t in targetArr) {
                if (!charDict.containsKey(t)) {
                    answer[index] = -1
                    count = -1
                    break
                } else {
                    count += charDict.getOrDefault(t, 0)
                }
            }
            if (count != 0) answer[index] = count
        }
        return answer.toIntArray()
    }
}