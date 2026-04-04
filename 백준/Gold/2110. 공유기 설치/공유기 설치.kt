private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val (N, C) = br.readLine().split(" ").map { it.toInt() }
    val houses = LongArray(N) { br.readLine().toLong() }.apply { sort() }

    var low = 1L
    var high = houses.last() - houses.first()
    var max = 0L

    while (low <= high) {
        val mid = (low + high) / 2

        if (houses.isAvailable(mid, C)) {
            max = mid
            low = mid + 1
        } else high = mid - 1
    }

    bw.write("$max")
    bw.close()
}

fun LongArray.isAvailable(dist: Long, C: Int): Boolean {
    var installed = 1
    var prev = this[0]

    for (i in 1 until size) {
        if (this[i] - prev >= dist) {
            installed++
            prev = this[i]
        }

        if (installed >= C) return true
    }

    return installed >= C
}