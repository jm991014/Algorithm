private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val cycle = 25 * 60
    val awake = 17 * 60

    repeat(br.readLine().toInt()) {
        val t = br.readLine().toInt()
        val total = (t * 60) + 30
        val cur = total % cycle

        if (cur < awake) write("ONLINE\n") else write("OFFLINE\n")
    }

    close()
}