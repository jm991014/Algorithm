class Solution {
    fun getLucky(s: String, k: Int): Int {
        var str = ""
        s.forEach { char ->
            str += (char.code - 'a'.code + 1)
        }
        repeat(k) {
            var sum = 0
            str.forEach { 
                sum += it.digitToInt()
            }
            str = sum.toString()
        }
        return str.toInt()
    }
}