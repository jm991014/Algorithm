import kotlin.math.*

class Solution {
    fun solution(n: Long): Long = sqrt(n.toDouble()).let {
        if (it.toLong() == ceil(it).toLong()) ((it + 1) * (it + 1)).toLong()
        else -1
    }
}