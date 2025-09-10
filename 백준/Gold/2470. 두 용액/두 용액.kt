import kotlin.math.abs

private val br = System.`in`.bufferedReader()

fun main() = with(StringBuilder()) {
    val N = br.readLine().toInt()
    val arr = br.readLine().split(" ").map(String::toLong).sorted().toLongArray()
    var s = 0
    var e = N - 1
    var minS = 0L
    var minE = 0L
    var min = Long.MAX_VALUE

    while (s < e) {
        val tmp = arr[s] + arr[e]
        
        if (abs(tmp) < min) {
            minS = arr[s]
            minE = arr[e]
            min = abs(tmp)
        }

        if (tmp < 0) s++ else e--
    }
    append("$minS $minE")
    println(this)
}
