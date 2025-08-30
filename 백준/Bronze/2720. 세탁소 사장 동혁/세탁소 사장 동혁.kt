private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    repeat(br.readLine().toInt()) {
        var change = br.readLine().toInt()
        val cnt = arrayOf(0, 0, 0, 0)
        while (change > 0) {
            when {
                change >= 25 -> {
                    change -= 25
                    cnt[0]++
                }

                change >= 10 -> {
                    change -= 10
                    cnt[1]++
                }

                change >= 5 -> {
                    change -= 5
                    cnt[2]++
                }

                else -> {
                    change -= 1
                    cnt[3]++
                }
            }
        }
        write("${cnt.joinToString(" ")}\n")
    }
    close()
}
