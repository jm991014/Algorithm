private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val limit = br.readLine().toInt()
    val speed = br.readLine().toInt()
    val diff = speed - limit

    val fine = when {
        diff >= 31 -> 500
        diff >= 21 -> 270
        diff >= 1 -> 100
        else -> 0
    }

    write(if (fine != 0) "You are speeding and your fine is $$fine." else "Congratulations, you are within the speed limit!")
    close()
}