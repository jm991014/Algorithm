class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val room = IntArray(1450)
        book_time.forEach {
            room[it[0].toMin()]++
            room[it[1].toMin() + 10]--
        }
        for (i in 0 until room.size - 10) room[i + 1] += room[i]
        return room.maxOf { it }
    }
    
    fun String.toMin() = this.substring(0, 2).toInt() * 60 + this.substring(3).toInt()
}