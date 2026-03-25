private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        val map = sortedMapOf<Int, Int>()

        repeat(br.readLine().toInt()) {
            val (operator, n) = br.readLine().split(" ")
            val N = n.toInt()
            when (operator) {

                "I" -> map[N] = map.getOrDefault(N, 0) + 1
                "D" -> if (map.isNotEmpty()) {
                    val key = if (N == 1) map.lastKey() else map.firstKey()

                    if (map[key] == 1) map.remove(key)
                    else map[key] = map.getOrDefault(key, 0) - 1
                }
            }
        }
        if (map.isEmpty()) write("EMPTY\n")
        else write("${map.lastKey()} ${map.firstKey()}\n")
    }
    close()
}
