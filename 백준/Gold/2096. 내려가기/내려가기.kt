private val br = System.`in`.bufferedReader()
private val bw = System.out.bufferedWriter()

fun main() {
    val N = br.readLine().toInt()
    val min = IntArray(3)
    val max = IntArray(3)

    val init = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    init.forEachIndexed { index, i ->
        min[index] = i
        max[index] = i
    }

    repeat(N - 1) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }

        val prevMin0 = min[0]
        val prevMin1 = min[1]
        val prevMin2 = min[2]

        val prevMax0 = max[0]
        val prevMax1 = max[1]
        val prevMax2 = max[2]

        min[0] = a + minOf(prevMin0, prevMin1)
        min[1] = b + minOf(prevMin0, minOf(prevMin1, prevMin2))
        min[2] = c + minOf(prevMin1, prevMin2)

        max[0] = a + maxOf(prevMax0, prevMax1)
        max[1] = b + maxOf(prevMax0, maxOf(prevMax1, prevMax2))
        max[2] = c + maxOf(prevMax1, prevMax2)
    }

    bw.write("${max.maxOrNull()} ${min.minOrNull()}")

    bw.close()
}