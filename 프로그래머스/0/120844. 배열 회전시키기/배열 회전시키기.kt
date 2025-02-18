class Solution {
    fun solution(numbers: IntArray, direction: String): IntArray = numbers.toMutableList().apply {
        if (direction == "right") {
            this.add(0, this[lastIndex])
            this.removeLast()
        }
        else {
            this.add(lastIndex + 1, this[0])
            this.removeFirst()
        }    
    }.toIntArray()
}