private val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val input = br.readLine().toInt()

    val color = when (input) {
        in (620..780) -> "Red"
        in (590 until 620) -> "Orange"
        in (570 until 590) -> "Yellow"
        in (495 until 570) -> "Green"
        in (450 until 495) -> "Blue"
        in (425 until 450) -> "Indigo"
        in (380 until 425) -> "Violet"
        else -> "Unknown"
    }

    write(color)
    close()
}