class Solution {
    fun solution(X: String, Y: String): String {
        val answer = StringBuilder()
        val elementArray = IntArray(10) { 0 }
        
        for (x in X) elementArray[x.digitToInt()] += 1

        for (y in Y) {
            val yInt = y.digitToInt()
            if (elementArray[yInt] > 0) {
                elementArray[yInt] -= 1
                answer.append(yInt)
            }
        }
        if (answer.isEmpty()) return "-1"
        val sortedResult = answer.toString().toCharArray().sortedDescending().joinToString("")
        return if (sortedResult[0] == '0') "0" else sortedResult    
    }
}